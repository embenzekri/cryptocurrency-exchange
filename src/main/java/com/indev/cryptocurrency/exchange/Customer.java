package com.indev.cryptocurrency.exchange;


import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final int amountInitial = 0;
    private String cryptoCurrency ;
    private int amountCryptoCurrency = amountInitial;
    private int amountDollars= amountInitial;
    public Customer withCryptoCurrency(String cryptoCurrency, int amount) {
        this.amountCryptoCurrency = amount ;
        this.cryptoCurrency = cryptoCurrency ;
        return this;
    }

    public Customer withBalance(int amountDollars) {
        this.amountDollars = amountDollars ;
        return this;
    }

    public int getAmountCryptoCurrency() {
        return amountCryptoCurrency;
    }

    public int getAmountDollars() {
        return amountDollars;
    }


    public String getCryptoCurrency() {
        return cryptoCurrency;
    }

    public void setCryptoCurrency(String cryptoCurrency) {
        this.cryptoCurrency = cryptoCurrency;
    }

    public void setAmountCryptoCurrency(int amountCryptoCurrency) {
        this.amountCryptoCurrency = amountCryptoCurrency;
    }

    public void setAmountDollars(int amountDollars) {
        this.amountDollars = amountDollars;
    }


    @Override
    public String toString() {
        String result ="";
        result +=  amountDollars+":$";
        if(amountCryptoCurrency !=0)
        {
            result += ","+amountCryptoCurrency+":"+cryptoCurrency ;
        }
        return result ;
    }
}
