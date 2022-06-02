package com.aforo255.appinvoice.models;
 
import java.io.Serializable;
 
import javax.persistence.*;
 
@Entity
@Table(name = "Customer")
public class CustomerModel implements Serializable {
    private static final long serialVersionUID = 1L;
 
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcustomer")
    private Integer idCustomer;
    @Column(name = "fullname")
    private String fullName;
    @Column(name = "email")
    private String email;
 
    public Integer getIdCustomer() {
        return idCustomer;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }
}
 