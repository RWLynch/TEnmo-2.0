package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Account {

    private int userId;
    private int accountId;
    private BigDecimal balance = new BigDecimal(0);

    public Account() {
    }

    public Account(int userId, int accountId, BigDecimal balance) {
        this.userId = userId;
        this.accountId = accountId;
        this.balance = balance;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
