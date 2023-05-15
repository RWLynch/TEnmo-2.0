package com.techelevator.tenmo.dao;


import com.techelevator.tenmo.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component

public class JdbcAccountDao implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Account getAccountByUserId(int userId) {
        Account account = new Account();
        String sql = "SELECT account_id, user_id, balance FROM account WHERE user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

        while (results.next()) {
            account = mapRowToAccount(results);
        }
        return account;
    }

    @Override
    public BigDecimal getBalanceByUserId(int userId) {
        BigDecimal balance= new BigDecimal(0.00);
        String sql = "SELECT balance FROM account WHERE user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

        if (results.next()) {
            balance = results.getBigDecimal("balance");
        }
        return balance;
    }

    private Account mapRowToAccount(SqlRowSet result) {
        Account account = new Account();
        account.setAccountId(result.getInt("account_id"));
        account.setUserId(result.getInt("user_id"));
        account.setBalance(result.getBigDecimal("balance"));
        return account;
    }

}
