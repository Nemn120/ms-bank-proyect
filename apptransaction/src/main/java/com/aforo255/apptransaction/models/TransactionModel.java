package com.aforo255.apptransaction.models;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
 
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;
 
@Document(collection = "transaction")
public class TransactionModel implements Serializable {
 
    private static final long serialVersionUID = 1L;
    
    @BsonId
	private String id ; 
    private Integer transactionId;
	private double amount ;
	private String type;
	private Integer idInvoice;
    private String creationDate;
    private String processDate;
    
    public TransactionModel() {
		Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");   
		this.setProcessDate(dateFormat.format(date));
    }
 
    public Integer getTransactionId() {
        return transactionId;
    }
    public String getProcessDate() {
        return processDate;
    }
    public void setProcessDate(String processDate) {
        this.processDate = processDate;
    }
    public String getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(Integer idInvoice) {
        this.idInvoice = idInvoice;
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
    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }
}