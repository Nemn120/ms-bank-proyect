package com.aforo255.apppay.controller;
 
import com.aforo255.apppay.dtos.TransactionRequest;
import com.aforo255.apppay.message.TransactionMessagePublish;
import com.aforo255.apppay.models.TransactionModel;
import com.aforo255.apppay.services.IPaymentService;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
@RestController
@RequestMapping("/api/pay")
public class PaymentControlller {
 
    @Autowired
    IPaymentService paymentService;
    @Autowired
	TransactionMessagePublish messageEvent;
 
    Logger logger = LoggerFactory.getLogger(PaymentControlller.class);
 
    @PostMapping("/deposit")
    public ResponseEntity<?> deposit(@RequestBody TransactionRequest request) throws Exception {
 
        logger.info("Post: InvoiceId {} - Amount {}", request.getIdInvoice(), request.getAmount());
        TransactionModel transactionModel = new TransactionModel();
        transactionModel.setIdInvoice(request.getIdInvoice());
        transactionModel.setAmount(request.getAmount());
        transactionModel.setType("pay");
        transactionModel = paymentService.add(transactionModel);
        messageEvent.sendDepositEvent(transactionModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionModel);
    }
}