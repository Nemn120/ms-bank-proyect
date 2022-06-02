package com.aforo255.appinvoice.repositories;
 
import com.aforo255.appinvoice.models.CustomerModel;
import com.aforo255.appinvoice.models.InvoiceModel;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IInvoiceRepository extends CrudRepository<InvoiceModel,Integer> {

    @Query(" SELECT F FROM InvoiceModel F JOIN F.customer C WHERE C.idCustomer= :id_customer ")
    List<InvoiceModel> findByIdcustomer(@Param("id_customer") Integer id_customer);
    
}