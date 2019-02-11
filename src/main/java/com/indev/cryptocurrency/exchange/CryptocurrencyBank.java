package com.indev.cryptocurrency.exchange;

import java.util.HashMap;

public class CryptocurrencyBank {

    private static int cmp = 0;

    private HashMap<Integer, Currency> currencies = new HashMap<>();
    private Customer buyerCustomer;
    private Customer sellerCustomer;

    public void addSupportedCryptoCurrency(String currencyName) {
        Currency currency = Currency.valueOf(currencyName);
        currencies.put(currency.getId(), currency);
    }

    public int requestTransaction(Customer buyerCustomer, int quantiteCurrency, String currency) {
        if(sellerCustomer != null){
            cmp++;
            if(sellerCustomer.sellCurrency(quantiteCurrency, currency, getPrice())){
                buyerCustomer.buyCurrency(quantiteCurrency, currency, getPrice());
                return quantiteCurrency;
            }
        }
        return 0;
    }

    public void addSeller(Customer sellerCustomer) {
        this.sellerCustomer = new Customer();
        this.sellerCustomer = sellerCustomer;
    }

    private int getPrice(){
        if(cmp == 1) return 1;
        return cmp*cmp - cmp;
    }
}
