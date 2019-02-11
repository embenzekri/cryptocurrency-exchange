package com.indev.cryptocurrency.exchange;

public class Customer {

    private String support ;
    private int balance ;
    private int price;

    public Customer withCryptocurrency(String support, int price) {
        price = price;
        support =support;
        return this;
    }


    public Customer withBalance(int Balance) {
        balance=Balance;
        return this;
    }

    @Override
    public String toString() {
        String string =balance+":$";
        if (price>0)
        string+= ","+price+":"+ support;
        return string;

    }


}
