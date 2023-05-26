package com.techelevator;

public class CheckingAccount extends BankAccount {
    private int checkingBalance = getBalance();

    //constructor
    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    public CheckingAccount(String accountHolder, String accountNumber) {
        super(accountHolder, accountNumber);
    }

    public int withdraw(int amountToWithdraw) {
//        int overdraftLimit = -100;
//        int overdraftFee = 10;
        if (getBalance() - amountToWithdraw > -100) {
            super.withdraw(amountToWithdraw);
        }
        if (getBalance() < 0) {
            super.withdraw(10);
        }
        return getBalance();
    }
}
