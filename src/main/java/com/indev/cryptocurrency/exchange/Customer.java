package com.indev.cryptocurrency.exchange;

import java.util.HashMap;
import java.util.Map;

public class Customer {

    Map<String,Integer> wallet = new HashMap<>();

    public Customer withCryptocurrency(String currency, int quantity) {
        wallet.put(currency,quantity);
        Market.addCustomer(this);
        return this;
    }

    public Customer withBalance(int quantity)
    {
        wallet.put("$",quantity);
        Market.addCustomer(this);
        return this;
    }

    @Override
    public String toString() {
        Integer ballance = wallet.get("$");
        Integer bitcoin = wallet.get("Bitcoin");
        Integer ethereum = wallet.get("Ethereum");
        String wallet = "";
        if(ballance == null){
            wallet += 0+":$";
        }
        else {
            wallet += ballance+":$";
        }
        if(bitcoin != null){
            wallet += ","+bitcoin+":Bitcoin";
        }
        else if (ethereum != null){
            wallet += ","+ethereum+":Ethereum";
        }
        return wallet;
    }

    public int buy(Customer buyerCustomer, int quantity, String currency) {
        return Market.buy(buyerCustomer,quantity,currency);
    }
}
