package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;

import java.math.BigDecimal;
import java.util.List;

public interface TransferDao {
    List<Transfer> getTransfers();
    boolean sendMoney(BigDecimal amount, Integer accountFrom, Integer accountTo, String note);
    void requestMoney(BigDecimal amount, int senderUserId, int recipientUserId, String note);
}
