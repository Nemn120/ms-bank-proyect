package com.aforo255.appinvoice.services;
 
import java.util.List;

import com.aforo255.appinvoice.models.CustomerModel;
import com.aforo255.appinvoice.models.InvoiceModel;
import com.aforo255.appinvoice.repositories.IInvoiceRepository;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class InvoiceService implements IInvoiceService {
 
    @Autowired
    IInvoiceRepository invoiceRepository;
 
    @Override
    public List<InvoiceModel> findAll() {
        return  (List<InvoiceModel>) invoiceRepository.findAll();
    }
 
    @Override
    public InvoiceModel update(InvoiceModel invoiceModel) {
        return invoiceRepository.save(invoiceModel);
    }
 
    @Override
    public InvoiceModel findById(Integer id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    @Override
    public List<InvoiceModel> findByIdcustomer(Integer idCustomer) {
        return invoiceRepository.findByIdcustomer(idCustomer);
    }
}