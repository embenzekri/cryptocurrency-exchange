package com.indev.cryptocurrency.exchange;

public class Customer {
    private String cryptocurrency;
    private Integer cryptocurrencyBalance;
    private Integer balance;

    public Customer() {
        balance=0;
    }

    public Customer withCryptocurrency(String cryptocurrency, int balance) {
        this.cryptocurrency=cryptocurrency;
        this.cryptocurrencyBalance=balance;
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
        if (cryptocurrencyBalance!=null)
            presentation+=","+cryptocurrencyBalance+":"+cryptocurrency;
        return presentation;
    }

    boolean hasEnaughBalanceToSell(Integer amount) {
    return this.cryptocurrencyBalance>=amount;
    }

    boolean hasEnoughBalanceToBuy(Integer amount){
        return this.balance>=amount;
    }

    boolean hasCryptocurencyBalance(){
        return this.cryptocurrency!=null;
    }

    boolean hasCryptocurency(String cryptocurrency){
        return this.cryptocurrency.equals(cryptocurrency);
    }


    Customer reduceBalance(int amount) {
        this.balance-=amount;
        return this;
    }

    Customer addBalance(int amount){
        this.balance+=amount;
        return this;
    }

    Customer reduceCryptocurrencyBalance(int amount) {
        if (this.cryptocurrency!=null)
        this.cryptocurrencyBalance-=amount;
        return this;
    }

    Customer addCryptocurrencyBalance(int amount){
        this.cryptocurrencyBalance+=amount;
        return this;
    }
}
