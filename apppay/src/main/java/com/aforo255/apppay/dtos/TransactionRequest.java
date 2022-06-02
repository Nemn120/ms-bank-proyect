package com.aforo255.apppay.dtos;
 
import java.io.Serializable;
 
public class TransactionRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idInvoice;
    private double amount;
 
    public TransactionRequest() {
 
    }
 
    public TransactionRequest(Integer accountId, double amount) {
        this.setIdInvoice(accountId);
        this.setAmount(amount);
    }

    public Integer getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(Integer idInvoice) {
        this.idInvoice = idInvoice;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}