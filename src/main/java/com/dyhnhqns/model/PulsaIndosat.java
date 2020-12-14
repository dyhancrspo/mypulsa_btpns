package com.dyhnhqns.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pulsa_indosat")
public class PulsaIndosat {
    @Id
    private String phoneNumber;

    @Column(name = "mobile_billing")
    private Integer mobileBilling;

    @Column(name = "status")
    private String status = "Waiting for Payment";

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getMobileBilling() {
        return mobileBilling;
    }

    public void setMobileBilling(Integer mobileBilling) {
        this.mobileBilling = mobileBilling;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PulsaIndosat{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", mobileBilling=" + mobileBilling +
                ", status='" + status + '\'' +
                '}';
    }
}
