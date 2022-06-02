package com.aforo255.apptransaction.services;

import com.aforo255.apptransaction.repositories.ITransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.aforo255.apptransaction.models.TransactionModel;

import java.util.List;

@Service
public class TransactionService implements ITransactionService {

    Logger logger = LoggerFactory.getLogger(TransactionService.class);

    @Autowired
    ITransactionRepository transactionRepository;

    @Override
    public TransactionModel add(TransactionModel transaction) {
        // TODO Auto-generated method stub
        return transactionRepository.save(transaction);
    }

    @Override
	@Cacheable(value="invoices", key="#invoiceId")
	public List<TransactionModel> findByInvoiceId(Integer invoiceId) {
        logger.info("SERVICE: Get Find By findByInvoiceId: {}", invoiceId);
        return transactionRepository.findByIdInvoice(invoiceId);
    }

    @Override
    public List<TransactionModel> findAll() {
        // TODO Auto-generated method stub
        return transactionRepository.findAll();
    }
}