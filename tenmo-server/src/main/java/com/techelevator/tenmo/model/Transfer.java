package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Transfer {

    private int transfer_id;
    private String transfer_type;
    private String transfer_status;
    private int account_from;
    private int account_to;
    private BigDecimal amount;
    private String note;

    public Transfer(int transfer_id, String transfer_type_desc, String transfer_status_desc, int account_from, int account_to, BigDecimal amount, String note) {
        this.transfer_id = transfer_id;
        this.transfer_type = transfer_type_desc;
        this.transfer_status = transfer_status_desc;
        this.account_from = account_from;
        this.account_to = account_to;
        this.amount = amount;
        this.note = note;
    }

    public int getTransfer_id() {
        return transfer_id;
    }

    public void setTransfer_id(int transfer_id) {
        this.transfer_id = transfer_id;
    }

    public String getTransfer_type() {
        return transfer_type;
    }

    public void setTransfer_type(String transfer_type) {
        this.transfer_type = transfer_type;
    }

    public String getTransfer_status() {
        return transfer_status;
    }

    public void setTransfer_status(String transfer_status) {
        this.transfer_status = transfer_status;
    }

    public int getAccount_from() {
        return account_from;
    }

    public void setAccount_from(int account_from) {
        this.account_from = account_from;
    }

    public int getAccount_to() {
        return account_to;
    }

    public void setAccount_to(int account_to) {
        this.account_to = account_to;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
