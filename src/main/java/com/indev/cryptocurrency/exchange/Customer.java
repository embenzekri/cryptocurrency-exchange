package com.indev.cryptocurrency.exchange;

public class Customer {
    private String cryptocurrency;
    private Integer balancesWithCryptocurrency;
    private Integer balance;

    public Customer() {
        balance=0;
    }

    public Customer withCryptocurrency(String cryptocurrency, int balance) {
        this.cryptocurrency=cryptocurrency;
        this.balancesWithCryptocurrency=balance;
        return this;
    }

    public Customer withBalance(int balance) {
        this.balance=balance;
        return this;
    }

    @Override
    public String toString() {
        String presentation="";
        presentation+=balance+":$";
        if (balancesWithCryptocurrency!=null)
            presentation+=","+balancesWithCryptocurrency+":"+cryptocurrency;
        return presentation;
    }
}
