package com.techelevator;

public class CheckingAccount extends BankAccount{
    private int checkingBalance = getBalance();

    @Override
    public int withdraw(){
        if (checkingBalance > (0-100.00)) {

        }
    }
}
