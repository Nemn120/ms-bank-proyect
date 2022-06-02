package com.aforo255.apptransaction.repositories;

import com.aforo255.apptransaction.models.TransactionModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITransactionRepository extends MongoRepository<TransactionModel, String> {
    @Query("{'idInvoice':?0}")
	public List<TransactionModel> findByIdInvoice(Integer accountId);
}