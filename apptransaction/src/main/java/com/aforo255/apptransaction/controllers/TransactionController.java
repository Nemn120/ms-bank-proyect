package com.aforo255.apptransaction.controllers;


import com.aforo255.apptransaction.models.TransactionModel;
import com.aforo255.apptransaction.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService transactionService;

    @GetMapping()
    public List<TransactionModel> listtransaction(){
        return transactionService.findAll();
    }

    @GetMapping("listar")
    public List<TransactionModel> listar (){

        return (List<TransactionModel>) transactionService.findAll();
    }

    @GetMapping ("/{invoice_id}")
    public ResponseEntity<?> getByInvoiceId (@PathVariable("invoice_id") Integer invoice_id){
        logger.info("CONTROLLER: Get By getByInvoiceId: {}", invoice_id);
        Iterable<TransactionModel> transaction= transactionService.findByInvoiceId(invoice_id);
        return ResponseEntity.ok(transaction);
    }
}
