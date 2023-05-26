package com.techelevator;

import java.util.List;
import java.util.ArrayList;

public class BankCustomer implements Accountable{
    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable> accounts = new ArrayList<>();

    //Constructor
    public BankCustomer(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public BankCustomer() {

    }

    //Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Accountable> getAccounts() {
        return accounts;
    }

    //methods

    int totalBalance = 0;
    @Override
    public int getBalance() {
        for (Accountable account : accounts) {
            totalBalance += account.getBalance();

        }
        return totalBalance;
    }

    public List getAccounts(List Accountable[]) {
        return accounts;
    }

    public void addAccount(Accountable newAccount) {
        accounts.add(newAccount);
    }

    public boolean isVip() {
        if (totalBalance > 25000.00) {
            return true;
        } else {
            return false;
        }
    }
}
