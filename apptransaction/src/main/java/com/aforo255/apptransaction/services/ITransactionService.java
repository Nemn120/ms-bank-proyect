package com.aforo255.apptransaction.services;
 
import com.aforo255.apptransaction.models.TransactionModel;

import java.util.List;

public interface ITransactionService {
    public TransactionModel add (TransactionModel transaction);
	public List<TransactionModel> findByInvoiceId(Integer accountId);
	public List<TransactionModel>  findAll() ;
}