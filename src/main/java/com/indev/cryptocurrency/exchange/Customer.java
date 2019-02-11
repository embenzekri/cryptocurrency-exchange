package com.indev.cryptocurrency.exchange;

import java.util.HashMap;

public class Customer {

    public HashMap<String,Integer> wallet = new HashMap<>();
    private String balance = "";
    private int k=0;

    public Customer() {
        wallet.put("$",0);
    }

    public Customer withCryptocurrency(String bitcoin, int amount) {
        wallet.put(bitcoin,amount);
        return this;
    }

    public Customer withBalance(int amount) {
        wallet.put("$",amount);
        return this;
    }

    @Override
    public String toString() {
        k=wallet.size();
        for (HashMap.Entry<String, Integer> entry : wallet.entrySet()) {
            balance+=entry.getValue()+":"+entry.getKey();
            if (k>1){
                balance+=",";
            }
            k--;
        }
        return balance;
    }
}
