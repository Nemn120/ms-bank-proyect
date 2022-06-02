package com.aforo255.appinvoice.services;
 
import java.util.List;
 
import com.aforo255.appinvoice.models.InvoiceModel;
 
public interface IInvoiceService {
    
    public List<InvoiceModel> findAll();
    public InvoiceModel findById (Integer id);
    public InvoiceModel update(InvoiceModel invoiceModel);
    List<InvoiceModel> findByIdcustomer(Integer idCustomer);
}