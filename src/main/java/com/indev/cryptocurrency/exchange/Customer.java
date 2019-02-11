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

        return (currenciesSolde != null);
    }

    public boolean isExistCurrency(String currency) {
        return (currenciesSolde.get(currency) != null);
    }

    void initCurrencies() {
        currenciesSolde = new HashMap<>();
        currenciesSolde.put("$", 0);
    }

    @Override
    public String toString() {
        String balance;
        StringBuilder stringBuilder = new StringBuilder();
        Iterator currenciesIterator =  currenciesSolde.entrySet().iterator();

        while(currenciesIterator.hasNext()) {
            Map.Entry entry = (Map.Entry) currenciesIterator.next();
            stringBuilder.append(currenciesBalanceParser(entry.getKey().toString()));
            if (currenciesIterator.hasNext())   stringBuilder.append(",");

        }
        balance=stringBuilder.toString();
        return balance;
    }

    private String currenciesBalanceParser(String currency) {
        return currenciesSolde.get(currency) + ":" + currency;
    }
}
