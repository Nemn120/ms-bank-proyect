package com.aforo255.apppay.repositories;
 
import com.aforo255.apppay.models.TransactionModel;
 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface ITransactionRepository extends CrudRepository<TransactionModel, Long>{
    
}