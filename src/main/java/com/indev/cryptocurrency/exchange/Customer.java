package com.indev.cryptocurrency.exchange;

public class Customer {
    private  Currency currency;
    private int Dollar;


    public Customer withCryptocurrency(String bitcoin, int i) {

        currency = new Currency(bitcoin,i);
        return this;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrencyNumb(int numb) {
        this.currency.setNumb(numb);
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public int getDollar() {
        return Dollar;
    }

    public void setDollar(int dollar) {
        Dollar = dollar;
    }

    @Override
    public String toString() {
        String result;
        result = Dollar+":$";
        if(currency!=null){
            result +=","+currency.getNumb()+":"+currency.getName();
        }
        return result;
    }

    public Customer withBalance(int i) {
        Dollar=i;
        return this;
    }
}
