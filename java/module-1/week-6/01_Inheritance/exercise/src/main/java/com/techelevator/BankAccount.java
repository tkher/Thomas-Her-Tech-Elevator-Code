package com.techelevator;

public class BankAccount {
    private String accountHolderName;
    private String accountNumber;
    private int balance = 0;

    //getters
    public String getAccountHolderName() {
        return accountHolderName;
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public BankAccount(){
    }

    //constructors
    public BankAccount(String accountHolderName, String accountNumber){
        this.accountHolderName=accountHolderName;
        this.accountNumber = accountNumber;
    }

    public BankAccount(String accountHolderName, String accountNumber, int balance) {
        this.accountHolderName=accountHolderName;
        this.accountNumber=accountNumber;
        this.balance=balance;
    }

    public int deposit(int amountToDeposit) {
        this.balance = balance + amountToDeposit;
        return balance;
    }

    public int withdraw(int amountToWithdraw) {
        this.balance = balance - amountToWithdraw;
        return balance;
    }

    public int withdraw() {
        return withdraw();
    }

}
