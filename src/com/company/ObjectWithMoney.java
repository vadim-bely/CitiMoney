package com.company;

public interface ObjectWithMoney {

    void moneySubtract(int value);

    void moneyAppend(int value);

    default String getAccountNumber() {
        return null;
    }

}
