package com.indev.cryptocurrency.exchange;

import java.util.HashMap;

public class CryptocurrencyBank {

    private HashMap<Integer, Currency> currencies = new HashMap<>();
    private Customer buyerCustomer;
    private Customer sellerCustomer;

    public void addSupportedCryptoCurrency(String currencyName) {
        Currency currency = Currency.valueOf(currencyName);
        currencies.put(currency.getId(), currency);
    }

    public int requestTransaction(Customer buyerCustomer, int quantiteCurrency, String currency) {
        if(sellerCustomer != null){
            if(sellerCustomer.sellCurrency(quantiteCurrency, currency)){
                buyerCustomer.buyCurrency(quantiteCurrency, currency);
                return quantiteCurrency;
            }
        }
        return 0;
    }

    public void addSeller(Customer sellerCustomer) {
        this.sellerCustomer = new Customer();
        this.sellerCustomer = sellerCustomer;
    }
}
