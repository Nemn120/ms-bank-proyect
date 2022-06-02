package com.aforo255.apppay.services;
 
import com.aforo255.apppay.models.TransactionModel;
 
public interface IPaymentService {
    public TransactionModel add (TransactionModel transactionModel);
}