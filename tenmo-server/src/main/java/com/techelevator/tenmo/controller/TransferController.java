package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RestController
public class TransferController {

    @Autowired
    TransferDao transferDao;

    public TransferController(TransferDao transferDao) {
        this.transferDao = transferDao;
    }

    @GetMapping(path = "/transfer")
    public List<Transfer> getTransactions() {
        List<Transfer> transferList = transferDao.getTransfers();
        return transferList;
    }

    @PostMapping(path = "/transfer/send")
    public boolean sendMoney(BigDecimal amount, Integer accountFrom, Integer accountTo, String note) {
        return transferDao.sendMoney(amount, accountFrom, accountTo, note);
    }


}
