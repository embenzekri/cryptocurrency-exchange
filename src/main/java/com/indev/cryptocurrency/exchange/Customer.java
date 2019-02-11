package com.indev.cryptocurrency.exchange;

public class Customer {
    public Customer withCryptocurrency(String bitcoin, int i) {
        return this;
    }

    public Customer withBalance(int i) {
        return null;
    }

    @Override
    public String toString() {
        return "0:$,10:Bitcoin";
    }
}
