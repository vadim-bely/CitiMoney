package com.company;

public class Citizen implements ObjectWithMoney {

    private String name;
    private int age;
    private String number;
    private int cash = 0;

    public Citizen(String name, int age, String number, int cash) {
        this.name = name;
        this.age = age;
        this.number = number;
        this.cash = cash;
    }

    public Citizen(String name, int age, String number) {
        this.name = name;
        this.age = age;
        this.number = number;
    }

    public Citizen(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getNumber() {
        return number;
    }

    public int getCash() {
        return cash;
    }

    public void setNumber(String number) {
        if(this.number != null)
        this.number = number;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    @Override
    public void moneySubtract(int value) {

        if (cash < value)  throw new IllegalArgumentException(" недостаточно денег ");
        this.cash -= value;
    }

    @Override
    public void moneyAppend(int value) {
        this.cash += value;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", number=" + number +
                ", cash=" + cash +
                '}';
    }
}
