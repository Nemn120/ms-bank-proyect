package com.aforo255.appinvoice.models;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
 
@Entity
@Table(name = "Invoice")
public class InvoiceModel {
 
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_invoice")
    private Integer idInvoice;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "state")
    private Integer state;

    @OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idcustomer" , insertable =false , updatable = false)
	@Fetch(FetchMode.JOIN)
	private CustomerModel customer;

    public Integer getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(Integer idInvoice) {
        this.idInvoice = idInvoice;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public com.aforo255.appinvoice.models.CustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }
}