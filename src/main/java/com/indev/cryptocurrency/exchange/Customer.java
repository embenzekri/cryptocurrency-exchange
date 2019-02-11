package com.indev.cryptocurrency.exchange;

import java.util.HashMap;

public class Customer {
    private String cryptoCurrency="" ;
    private int cryptoCurrencyQuantity=0;
    private int balance;




    public Customer withCryptocurrency(String cryptocurrency, int quantity) {
        this.cryptoCurrency = cryptocurrency;
        this.cryptoCurrencyQuantity+=quantity;

        return this;
    }

    public Customer withBalance(int balance) {
        this.balance = balance;
        return this;
    }



    public void reduceBalance(int balance){
        this.balance-=balance;
    }


    public String getCryptoCurrency() {
        return cryptoCurrency;
    }

    @Override
    public String toString() {


            String displayCustomer = this.balance+":$";
            if(!cryptoCurrency.trim().isEmpty()){
                displayCustomer+=","+cryptoCurrencyQuantity+":"+cryptoCurrency;
            }
            return displayCustomer;

    }


}
