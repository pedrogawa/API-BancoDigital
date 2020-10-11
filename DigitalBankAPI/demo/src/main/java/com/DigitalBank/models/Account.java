package com.DigitalBank.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Random;


@Entity
public class Account extends AbstractEntity {

    Random random = new Random();

    private int accountNumber = 1000000 + random.nextInt(9000000);
    private int agency = 1000 + random.nextInt(9000);
    private int bankCode = 260;

    public Account() {
    }

    public Account(int accountNumber, int agency, int bankCode, User user) {
        this.accountNumber = accountNumber;
        this.agency = agency;
        this.bankCode = bankCode;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAgency() {
        return agency;
    }

    public void setAgency(int agency) {
        this.agency = agency;
    }

    public int getBankCode() {
        return bankCode;
    }

    public void setBankCode(int bankCode) {
        this.bankCode = bankCode;
    }

}
