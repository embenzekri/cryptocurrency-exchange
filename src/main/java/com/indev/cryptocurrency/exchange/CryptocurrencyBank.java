package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;

public class CryptocurrencyBank {

    private ArrayList<String> supportedCryptoCurrencies =  new ArrayList<>();
    Market market = new Market();
    public void addSupportedCryptoCurrency(String currency) {
        supportedCryptoCurrencies.add(currency);
    }

    public int requestTransaction(Customer buyerCustomer, int quantity, String currency) {
        market.addBuyer(buyerCustomer);
        return market.buy(buyerCustomer,quantity,currency);
    }

    public void addSeller(Customer sellerCustomer) {
        market.addSeller(sellerCustomer);
    }
}
