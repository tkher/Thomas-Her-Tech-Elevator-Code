package com.techelevator;

public class CheckingAccount extends BankAccount {
    private int checkingBalance = getBalance();

    //constructor
    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    public CheckingAccount() {
        super();
    }

    public int withdraw(int amountToWithdraw) {
        super.withdraw();
        int overdraftLimit = -100;
        int overdraftFee = -10;
        if ((withdraw() > overdraftLimit)) {
            checkingBalance = withdraw() - amountToWithdraw - overdraftFee;
        }
        return checkingBalance;
    }
}
