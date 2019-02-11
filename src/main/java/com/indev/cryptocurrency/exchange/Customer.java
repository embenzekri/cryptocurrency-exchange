package com.indev.cryptocurrency.exchange;

import java.util.HashMap;

public class Customer {

    private HashMap<String, Integer> balanceHashMap = new HashMap<>();
    private static final String DOLLAR = "Dollar";
    private static final String BITCOIN = "Bitcoin";
    private static final String ETHEREUM = "Ethereum";

    public Customer() {
        populateHashMap();
    }

    private void populateHashMap() {
        balanceHashMap.put(DOLLAR, 0);
    }

    public Customer withCryptocurrency(String currencyName, int balance) {
        if(!isCurrencyExist(currencyName)){
            balanceHashMap.put(currencyName, balance);
        }
        return this;
    }

    private boolean isCurrencyExist(String currencyName){
        if(balanceHashMap.containsKey(currencyName)) return true;
        return false;
    }

    public Customer withBalance(int dollarBalance) {
        int balance = balanceHashMap.get(DOLLAR);
        balanceHashMap.put(DOLLAR, balance + dollarBalance);
        return this;
    }

    @Override
    public String toString() {
        String present = balanceHashMap.get(DOLLAR) + ":$";
        if(isCurrencyExist(BITCOIN)) present += "," + balanceHashMap.get(BITCOIN) + ":" + BITCOIN;
        if(isCurrencyExist(ETHEREUM)) present += "," + balanceHashMap.get(ETHEREUM) + ":" + ETHEREUM;
        return present;
    }
}
