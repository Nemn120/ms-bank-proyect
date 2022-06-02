package com.aforo255.apppay.models;
 
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
 
import javax.persistence.*;
 
@Entity
@Table(name = "payment")
public class TransactionModel implements Serializable {
 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idOperation;
	@Column(name = "id_invoice")
	private Integer idInvoice;
	private double amount;
	private String type;
	@Column(name = "date")
	private String date;


	public TransactionModel() {
		Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");   
		this.setDate(dateFormat.format(date));
    }

	public Integer getIdOperation() {
		return idOperation;
	}

	public void setIdOperation(Integer idOperation) {
		this.idOperation = idOperation;
	}

	public String getDate() {
		return date;
	}
 
	public void setDate(String creationDate) {
		this.date = creationDate;
	}
	public double getAmount() {
		return amount;
	}
 
	public void setAmount(double amount) {
		this.amount = amount;
	}
 
	public String getType() {
		return type;
	}
 
	public void setType(String type) {
		this.type = type;
	}

	public Integer getIdInvoice() {
		return idInvoice;
	}

	public void setIdInvoice(Integer idInvoice) {
		this.idInvoice = idInvoice;
	}
}