package com.indev.cryptocurrency.exchange;

public class Customer {
    private String cryptoCurrency;
    private int balance;
    private int cryptoCurrencyAmount;


    public Customer withCryptocurrency(String bitcoin, int i) {
        this.cryptoCurrency = bitcoin;
        return this;
    }

    public Customer withBalance(int balance) {
        this.balance = balance;
        return this;
    }

    @Override
    public String toString() {
        String stringToReturn = "";
        stringToReturn += balance +":$";
        if (cryptoCurrencyAmount > 0)
            stringToReturn += "," + cryptoCurrency + ":" + cryptoCurrency;
        return stringToReturn;
    }
}
