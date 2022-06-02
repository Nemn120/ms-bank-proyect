package com.aforo255.appinvoice.controller;

import java.util.List;

import com.aforo255.appinvoice.metrics.IncreaseCounterAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aforo255.appinvoice.models.InvoiceModel;
import com.aforo255.appinvoice.services.IInvoiceService;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {

	@Autowired
	private IInvoiceService accountService;

	@Autowired
	private IncreaseCounterAccount increaseCounterAccount;

	@GetMapping()
	public List<InvoiceModel> get() {
	 	increaseCounterAccount.increaseCounter();
		return accountService.findAll();
	}

	@GetMapping("/{id_customer}")
	public List<InvoiceModel> get(@PathVariable("id_customer") Integer id_customer) {
		increaseCounterAccount.increaseCounter();
		return accountService.findByIdcustomer(id_customer);
	}

}
	