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
        int withdrawWithFee = amountToWithdraw + 2;
        if (getBalance() - withdrawWithFee >= 0){
            super.withdraw(amountToWithdraw);
        }
        if (getBalance() <= 149.00) {
            super.withdraw(2);
        }
        return getBalance();
    }
}
