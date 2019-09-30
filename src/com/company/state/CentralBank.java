package com.company.state;

import com.company.ObjectWithMoney;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

public class CentralBank {

    private String accountNumber;
    private int accountMoney = 0;
    private String name;
    private boolean organization = true;

    private CentralBank(int startMoney, String name, boolean organization, String accountNumber) {
        this.accountMoney = startMoney;
        this.name = name;
        this.organization = organization;
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getAccountMoney() {
        return accountMoney;
    }

    public String getName() {
        return name;
    }

    private void moneySubtract(int value) {

        if (accountMoney < value)  throw new IllegalArgumentException(" недостаточно денег ");
        accountMoney -= value;
    }

    private void moneyAppend(int value) {
        accountMoney += value;
    }




    public static List<String> transaction = new LinkedList<>();

    private static List<CentralBank> accountList = new LinkedList<>();

    public static List<CentralBank> getAccountList() {
        return accountList;
    }
    
    public static void accountMoneyAppend(ObjectWithMoney object, String accountNumber, int value) {
        object.moneySubtract(value);
        CentralBank.getAccount(accountNumber).moneyAppend(value);
    }

    public static void accountMoneySubtract(String accountNumber, ObjectWithMoney object, int value) {
        CentralBank.getAccount(accountNumber).moneySubtract(value);
        object.moneyAppend(value);
    }

    public static String createAccount(String name, boolean organization) {
        return createAccount(name, organization, 0);
    }

    public static String createAccount(String name, boolean organization,  int startMoney) {
        String accountNumber = Integer.toString(GregorianCalendar.getInstance().get(Calendar.YEAR));

        int number = accountList.size() + 1;

        accountNumber += number < 10 ?
        "000" + number : number < 100 ?
        "00" + number : number < 1000 ?
        "0" + number : number;

        accountList.add(new CentralBank(startMoney, name, organization, accountNumber));

        return accountNumber;
    }

    public static CentralBank getAccount(String accountNumber) {
        for (CentralBank ac : accountList) {
                if (ac.getAccountNumber().equals(accountNumber)) {
                    return ac;
                }
        }
        return null;
    }

    public static boolean transaction(String accountIn, String accountOut, int value) {
        CentralBank.getAccount(accountIn).moneySubtract(value);
        CentralBank.getAccount(accountOut).moneyAppend(value);
        return true;
    }

    @Override
    public String toString() {
        return "CentralBank{" +
        "accountNumber='" + accountNumber + '\'' +
        ", accountMoney=" + accountMoney +
        ", name='" + name + '\'' +
        ", organization=" + organization +
        '}';
        }
}
