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
        int overdraftLimit = -100;
        int overdraftFee = -10;
        if (checkingBalance > overdraftLimit) {
            super.withdraw(amountToWithdraw);
        }
        if (checkingBalance < 0) {
            super.withdraw(amountToWithdraw + 10);
        }
        return checkingBalance;
    }
}
