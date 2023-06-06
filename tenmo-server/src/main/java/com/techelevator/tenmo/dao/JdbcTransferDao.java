package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component

public class JdbcTransferDao implements TransferDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcTransferDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Transfer> getTransfers() {
        String sql = "SELECT * FROM transfer";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        List<Transfer> history = new ArrayList<>();
        while (results.next()) {
            history.add(mapRowToTransfer(results));
        }
        return history;
    }

    @Override
    public boolean sendMoney(BigDecimal amount, Integer accountFrom, Integer accountTo, String note) {
        String sql = "START TRANSACTION; " +
                "UPDATE account SET balance = balance - ? " +
                "WHERE user_id = ?; " +
                "UPDATE account SET balance = balance + ? " +
                "WHERE user_id = ?; " +
                "INSERT INTO transfer (transfer_type, transfer_status, account_from, account_to, amount, note) " +
                "VALUES ('Send', 'Approved', ?, ?, ?, ?); " +
                "COMMIT; ";
        try {
            jdbcTemplate.update(sql, amount, accountFrom, amount, accountTo, accountFrom, accountTo, amount, note);
        } catch (DataIntegrityViolationException e) {
            sql = "ROLLBACK;";
            jdbcTemplate.update(sql);
            return false;
        }
        return true;
    }

    @Override
    public void requestMoney(BigDecimal amount, int senderUserId, int recipientUserId, String note) {
        String sql = "INSERT INTO transfer (transfer_type, transfer_status, account_to, account_from, amount, note) " +
                "VALUES ('Request', 'Pending', (SELECT account_id FROM account WHERE user_id = ?), (SELECT account_id FROM account WHERE user_id = ?), ?, ?);";
        jdbcTemplate.update(sql, recipientUserId, senderUserId, amount, note);
    }

    private Transfer mapRowToTransfer(SqlRowSet rowSet) {
        Transfer transfer = new Transfer();
        transfer.setTransfer_id(rowSet.getInt("transfer_id"));
        transfer.setTransfer_type(rowSet.getString("transfer_type"));
        transfer.setTransfer_status(rowSet.getString("transfer_status"));
        transfer.setAccount_from(rowSet.getInt("account_from"));
        transfer.setAccount_to(rowSet.getInt("account_to"));
        transfer.setAmount(rowSet.getBigDecimal("amount"));
        transfer.setNote(rowSet.getString("note"));
        return transfer;
    }
}
