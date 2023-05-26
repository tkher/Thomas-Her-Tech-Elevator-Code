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
    public int withdraw(int amountToWithdraw) {
        if (savingsBalance < 150.00) {
            super.withdraw(amountToWithdraw - 2);
        }
        return savingsBalance;
    }
}
