package com.company.state;

import com.company.ObjectWithMoney;

import java.lang.reflect.Array;
import java.util.*;

public class CentralBank {

    private String accountNumber;
    private int accountMoney;
    private String name;
    private boolean organization = true;
    private String personalPrivateNumber;

    private CentralBank(int startMoney, String name, boolean organization, String accountNumber, String personalPrivateNumber) {
        this.accountMoney = startMoney;
        this.name = name;
        this.organization = organization;
        this.accountNumber = accountNumber;
        this.personalPrivateNumber = personalPrivateNumber;
    }


    private void moneySubtract(int value) {

        if (accountMoney < value)  throw new IllegalArgumentException(" недостаточно денег ");
        accountMoney -= value;
    }

    private void moneyAppend(int value) {
        accountMoney += value;
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



    private static List<String[]> transaction = new LinkedList<>();
    private static List<CentralBank> accountList = new LinkedList<>();

    public static List<CentralBank> getAccountList() {
        return accountList;
    }

    public static List<String[]> getTransaction() {
        return transaction;
    }

    public static void accountMoneyAppend(ObjectWithMoney object, int value) {
        object.moneySubtract(value);
        CentralBank.getAccount(object.getAccountNumber()).moneyAppend(value);
    }

    public static void accountMoneySubtract(ObjectWithMoney object, int value) {
        CentralBank.getAccount(object.getAccountNumber()).moneySubtract(value);
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

        int num = new Random().nextInt(1000);
        String pNum = num < 10 ? "00" + num : num < 100 ? "0" + num : "" + num;

        accountList.add(new CentralBank(startMoney, name, organization, accountNumber, pNum));
        return accountNumber;
    }

    public static CentralBank getAccount(String accountNumber) {
        for (CentralBank ac : accountList) {
                if (ac.getAccountNumber().equals(accountNumber)) {
                    return ac;
                }
        }
        throw new IllegalArgumentException(" счёт не найден ");
    }

    public static boolean transaction(String accountIn, String accountOut, int value) {
        CentralBank.getAccount(accountIn).moneySubtract(value);
        CentralBank.getAccount(accountOut).moneyAppend(value);
        transaction.add(new String[] {accountIn, accountOut, Integer.toString(value)});
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
