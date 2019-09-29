package com.company.operation;

import com.company.ObjectWithMoney;

public class operation {

    private int number;
    private ObjectWithMoney citizenIn;
    private ObjectWithMoney citizenOut;
    private int cash;

     public operation(int number, ObjectWithMoney citizenIn, ObjectWithMoney citizenOut, int cash) {
        this.number = number;
        this.citizenIn = citizenIn;
        this.citizenOut = citizenOut;
        this.cash = cash;
        op(citizenIn, citizenOut, cash);
    }

    protected void op(ObjectWithMoney in, ObjectWithMoney out, int value) {
        in.moneySubtract(value);
        out.moneyAppend(value);
    }

    public int getNumber() {
         return number;
    }

    public ObjectWithMoney getObjectIn() {
        return citizenIn;
    }

    public ObjectWithMoney getObjectOut() {
        return citizenOut;
    }

    public int getCash() {
        return cash;
    }

    @Override
    public String toString() {
        return "operation{" +
                "number=" + number +
                ", citizenIn=" + citizenIn.getClass() +
                ", citizenOut=" + citizenOut.getClass() +
                ", cash=" + cash +
                '}';
    }

}
