package com.indev.cryptocurrency.exchange;

public class Customer {
    private int ammount;
    private int balance;
    private String currency;

    public Customer withCryptocurrency(String currency, int ammount) {
        this.currency = currency;
        this.ammount = ammount;
        return this;
    }

    public Customer withBalance(int balance) {
        this.balance = balance;
        return this;
    }

    @Override
    public String toString() {
        return balance + ":$" +
                (ammount == 0 ? "" : "," + ammount + ":" + currency);
    }

    public boolean hasCurrency(String currency) {
        return this.currency.equals(currency);
    }

    public void selle(int ammount, int price) {
        this.ammount -= ammount;
        balance += ammount*price;
    }

    public void buy(int ammount, String currency, int price) {
        this.ammount += ammount;
        balance -= ammount*price;
        this.currency = currency;
    }
}
