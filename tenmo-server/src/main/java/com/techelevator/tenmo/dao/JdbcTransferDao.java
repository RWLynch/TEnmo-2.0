package com.techelevator.tenmo.dao;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;

public class JdbcTransferDao implements TransferDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcTransferDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean sendMoney(BigDecimal amount, int senderUserId, int recipientUserId, String note) throws Exception {
        String sql = "START TRANSACTION; " +
                "UPDATE account SET balance = balance - ? " +
                "WHERE user_id = ?; " +
                "UPDATE account SET balance = balance + ? " +
                "WHERE user_id = ?; " +
                "INSERT INTO transfer (transfer_type, transfer_status, account_from, account_to, amount, note) " +
                "VALUES ('Send', 'Approved', (SELECT account_id FROM account WHERE user_id = ?), (SELECT account_id FROM account WHERE user_id = ?), ?, ?); " +
                "COMMIT; ";
        try {
            jdbcTemplate.update(sql, amount, senderUserId, amount, recipientUserId, senderUserId, recipientUserId, amount, note);
        } catch (DataIntegrityViolationException e) {
            sql = "ROLLBACK;";
            jdbcTemplate.update(sql);
            throw new Exception();
        }
        return true;
    }

    @Override
    public void requestMoney(BigDecimal amount, int senderUserId, int recipientUserId, String note) {
        String sql = "INSERT INTO transfer (transfer_type, transfer_status, account_to, account_from, amount, note) " +
                "VALUES ('Request', 'Pending', (SELECT account_id FROM account WHERE user_id = ?), (SELECT account_id FROM account WHERE user_id = ?), ?, ?);";
        jdbcTemplate.update(sql, recipientUserId, senderUserId, amount, note);
    }
}
