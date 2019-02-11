package com.indev.cryptocurrency.exchange;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Customer {
    HashMap<String, Integer> currenciesSolde;

    public Customer withCryptocurrency(String currency, int amount) {
        if (isExistCurrencies()) {
            if (isExistCurrency(currency)) {
                currenciesSolde.replace(currency, currenciesSolde.get(currency) + amount, currenciesSolde.get(currency));
            } else currenciesSolde.put(currency, amount);

        } else {
            initCurrencies();
            withCryptocurrency(currency, amount);
        }
        return this;
    }

    public Customer withBalance(int amount) {
        initCurrencies();
        currenciesSolde.replace("$",currenciesSolde.get("$"),currenciesSolde.get("$")+amount);
    return this;}

    boolean isExistCurrencies() {
        if (currenciesSolde == null) {
            currenciesSolde = new HashMap<String, Integer>();
            return false;
        } else {
            return true;
        }
    }

    public boolean isExistCurrency(String currency) {
        if (currenciesSolde.get(currency) == null) {
            return false;
        } else return true;
    }

    void initCurrencies() {
        currenciesSolde = new HashMap<String, Integer>();
        currenciesSolde.put("$", 0);
    }

    @Override
    public String toString() {
        String balance = "";
//        for (String key : currenciesSolde.keySet()) {
//            balance += currenciesBalanceParser(key);
//
//            balance +=",";
//        }

        Iterator currenciesIterator =  currenciesSolde.entrySet().iterator();

        while(currenciesIterator.hasNext()) {
            Map.Entry entry = (Map.Entry) currenciesIterator.next();
            balance+= currenciesBalanceParser(entry.getKey().toString());
            if (currenciesIterator.hasNext())balance +=",";
        }





        return balance;
    }

    private String currenciesBalanceParser(String currency) {
        return currenciesSolde.get(currency) + ":" + currency;
    }
}
