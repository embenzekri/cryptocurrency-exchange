package com.indev.cryptocurrency.exchange;

import java.util.HashMap;

public class CryptocurrencyBank {

    private static int numberBuyers = 0;

    private HashMap<Integer, Currency> currencies = new HashMap<>();
    private Customer sellerCustomer;

    public void addSupportedCryptoCurrency(String currencyName) {
        Currency currency = Currency.valueOf(currencyName);
        currencies.put(currency.getId(), currency);
    }

    public int requestTransaction(Customer buyerCustomer, int quantiteCurrency, String currency) {
        if(sellerCustomer != null){
            numberBuyers++;
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
        if(numberBuyers == 1) return 1;
        return numberBuyers * numberBuyers - numberBuyers;
    }
}
