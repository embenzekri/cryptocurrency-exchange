package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;
import java.util.List;

public class CryptocurrencyBank {

    private List<String> supportedCryptoCurrencies = new ArrayList<>();
    private List<Customer> sellers = new ArrayList<>();
    private int numberOfBuyers = 0;


    public void addSupportedCryptoCurrency(String cryptoCurrency) {
        supportedCryptoCurrencies.add(cryptoCurrency);
    }

    public int requestTransaction(Customer buyerCustomer, int numberOfCryptoCurrency, String cryptoCurrency) {
        if (hasCryptoCurrency(cryptoCurrency)) {
            Customer sellerCustomer = sellers.remove(0);
            numberOfBuyers++;
            int cryptoCurrencyPrice = 1;
            if(numberOfBuyers > 1)
                cryptoCurrencyPrice = numberOfBuyers*numberOfBuyers - numberOfBuyers;
            int boughtQuantity = sellerCustomer.transactionWith(buyerCustomer, numberOfCryptoCurrency, cryptoCurrency, cryptoCurrencyPrice);
            sellers.add(sellerCustomer);
            return boughtQuantity;
        }
        return 0;
    }

    private boolean hasCryptoCurrency(String cryptoCurrency) {
        return supportedCryptoCurrencies.contains(cryptoCurrency) && !sellers.isEmpty() && sellers.get(0).has(cryptoCurrency);
    }

    public void addSeller(Customer sellerCustomer) {
        sellers.add(sellerCustomer);
    }
}
