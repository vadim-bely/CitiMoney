package com.company.operation;

import com.company.ObjectWithMoney;
import com.company.state.State;

public class ShopOp extends operation {

    private final float NDS = 0.2F; // NDS 20%
    private int nds;


    public ShopOp(int number, ObjectWithMoney citizenIn, ObjectWithMoney objectOut, int cash, State state ) {
        super(number, citizenIn, objectOut, cash);
        nds = nds(cash);
        state.tax(citizenIn, nds);

    }

    private int nds(int value) {
       return Math.round(value * NDS);
    }

    @Override
    public int getCash() {
        return super.getCash() + nds;
    }

    public float getNDS() { // процент
        return NDS;
    }

    public int getNds() { // процент от стоимости
        return nds;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "number=" + getNumber() +
                ", citizenIn=" + getObjectIn().getClass().getName() +
                ", citizenOut=" + getObjectOut().getClass().getName() +
                ", cash=" + getCash() +
                ", nds=" + getNds() +
                '}';
    }
}
