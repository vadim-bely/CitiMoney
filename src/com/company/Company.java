package com.company;

import com.company.state.CentralBank;

public class Company implements ObjectWithMoney{

    private String comName;
    private String accountNumber;
    private int cash;

    public Company(String comName, int cash) {
        this.comName = comName;
        this.accountNumber = CentralBank.createAccount(comName, true);
        this.cash = cash;
    }

    public Company(String comName) {
        this.comName = comName;
        this.accountNumber = CentralBank.createAccount(comName, true);
        this.cash = 0;
    }



    public String getComName() {
        return comName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public void moneySubtract(int value) {

        if (cash < value)  throw new IllegalArgumentException(" недостаточно денег ");
        cash -= value;
    }

    @Override
    public void moneyAppend(int value) {
        cash += value;
    }
}
