package com.indev.cryptocurrency.exchange;

public class Customer {
    
    private String currency;
    private int quantity = 0;
    private int balance = 0;

    public Customer() {
        this.currency = "";
    }

    @Override
    public String toString() {
        if (quantity != 0) {
            return String.format("%s:$,%s:%s", balance, quantity, currency);
        } else {
            return String.format("%s:$", balance);
        }
    }

    public Customer(String currency, int quantity, int balance) {
        this.currency = currency;
        this.quantity = quantity;
        this.balance = balance;
    }

    public Customer withCryptocurrency(String bitcoin, int i) {
        return new Customer(bitcoin, i, balance);
    }

    public Customer withBalance(int i) {
        return new Customer(currency, quantity, i);
    }

    public String getCurrency() {
        return currency;
    }

    public void sell(int quantity, int unitPrice) {
        this.quantity -= quantity;
        this.balance += unitPrice * quantity;
    }

    public void buy(int quantity, int unitPrice, String currency) {
        this.quantity += quantity;
        this.balance -= unitPrice * quantity;
        this.currency = currency;
    }
}
