package com.techelevator.tenmo.dao;

import java.math.BigDecimal;

public interface TransferDao {
    boolean sendMoney(BigDecimal amount, int senderUserId, int recipientUserId, String note) throws Exception;
    void requestMoney(BigDecimal amount, int senderUserId, int recipientUserId, String note);
}
