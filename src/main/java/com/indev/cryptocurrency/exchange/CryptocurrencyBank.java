package com.indev.cryptocurrency.exchange;

import java.util.HashMap;

public class CryptocurrencyBank {

    private HashMap<Integer, Currency> currencies = new HashMap<>();

    public void addSupportedCryptoCurrency(String currencyName) {
        Currency currency = Currency.valueOf(currencyName);
        currencies.put(currency.getId(), currency);
    }

    public int requestTransaction(Customer buyerCustomer, int i, String bitcoin) {
        return 0;
    }

    public void addSeller(Customer sellerCustomer) {
    }
}
