package com.aforo255.appinvoice.dtos;

public class TransactionRequest {
    
    private Integer idOperation;
	private double amount;
	private String type;
    private String creationDate;
    private Integer idInvoice;
    
    public Integer getIdOperation() {
        return idOperation;
    }

    public Integer getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(Integer idInvoice) {
        this.idInvoice = idInvoice;
    }

    public String getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void setIdOperation(Integer idOperation) {
        this.idOperation = idOperation;
    }
}