package com.jitterted.ebp.blackjack;

public class Wallet {
    private boolean isEmpty = true;
    private int balance;

    //CMD_SHIFT_T = Toggle Prod & Test
    //F2 = Go to red line
    //Opt-Enter = Fix
    public boolean isEmpty(){
        return balance == 0;
    }
    public void addMoney(int amount) {
        if (amount < 0)  throw new IllegalArgumentException();
        this.balance += amount;
        this.isEmpty = false;
    }

    public int getBalance() {
        return balance;
    }

    public void bet(int amount) {
        if (balance - amount < 0) throw new IllegalArgumentException();
        balance = balance-amount;

    }
}
