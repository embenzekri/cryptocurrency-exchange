package com.indev.cryptocurrency.exchange;

public class Customer {
    private String cryptoCurrency;

    public Customer withCryptocurrency(String bitcoin, int i) {
        this .cryptoCurrency = bitcoin;
        return this;
    }

    public Customer withBalance(int i) {
        return null;
    }

    @Override
    public String toString() {
        return "0:$,10:" + cryptoCurrency;
    }
}
