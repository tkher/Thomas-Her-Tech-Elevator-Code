package com.techelevator;

public class SavingsAccount extends BankAccount{
    private int savingsBalance = getBalance();

    //Constructor
    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    @Override
    public int withdraw() {
        super.withdraw();
        int serviceCharge = 2;
        if (withdraw() < 150.00) {
            savingsBalance = withdraw() - serviceCharge;
        }
        return savingsBalance;
    }
}
