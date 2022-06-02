package com.aforo255.apppay.services;
 
import javax.transaction.Transactional;
 
import com.aforo255.apppay.models.TransactionModel;
import com.aforo255.apppay.repositories.ITransactionRepository;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class PaymentService implements IPaymentService {
 
    @Autowired
	private ITransactionRepository transactionRepositoy;
 
    @Override
    @Transactional
    public TransactionModel add(TransactionModel transactionModel) {
        return transactionRepositoy.save(transactionModel);
    }
    
}