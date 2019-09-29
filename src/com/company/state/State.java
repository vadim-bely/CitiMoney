package com.company.state;

import com.company.ObjectWithMoney;

public class State {

    public int money;

    public void moneyAppend(int value) {
       this.money += value;
    }

    public void tax (ObjectWithMoney object, int money){
        object.moneySubtract(money);
        this.money += money;
    }
}
