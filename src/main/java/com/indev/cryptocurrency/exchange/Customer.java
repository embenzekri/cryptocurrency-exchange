package com.indev.cryptocurrency.exchange;

public class Customer {
    private String cryptoCurrency;
    private int balance;
    private int cryptoCurrencyAmount;


    public Customer withCryptocurrency(String bitcoin, int cryptoCurrencyAmount) {
        this.cryptoCurrency = bitcoin;
        this.cryptoCurrencyAmount = cryptoCurrencyAmount;
        return this;
    }

    public int getBalance() {
        return balance;
    }

    public int getCryptoCurrencyAmount() {
        return cryptoCurrencyAmount;
    }

    public String getCryptoCurrency() {
        return cryptoCurrency;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setCryptoCurrencyAmount(int cryptoCurrencyAmount) {
        this.cryptoCurrencyAmount = cryptoCurrencyAmount;
    }

    public void setCryptoCurrency(String cryptoCurrency) {
        this.cryptoCurrency = cryptoCurrency;
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
            stringToReturn += "," + cryptoCurrencyAmount + ":" + cryptoCurrency;
        return stringToReturn;
    }

}
