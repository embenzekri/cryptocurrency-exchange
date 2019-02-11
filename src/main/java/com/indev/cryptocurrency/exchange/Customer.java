package com.indev.cryptocurrency.exchange;

import java.util.HashMap;

public class Customer {
    private HashMap<String,Integer> cryptocurrencies = new HashMap<>();
    private int balance;

    public Customer withCryptocurrency(String cryptocurrency, int quantity) {
        if(cryptocurrencies.get(cryptocurrency)==null)
            cryptocurrencies.put(cryptocurrency,quantity);
        else
            cryptocurrencies.replace(cryptocurrency,cryptocurrencies.get(cryptocurrency)+quantity);
        return this;
    }

    public Customer withBalance(int balance) {
        this.balance = balance;
        return this;
    }

    public HashMap<String, Integer> getCryptocurrencies() {
        return cryptocurrencies;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return CustomerDisplayer.displayCustomer(this);
    }
}
