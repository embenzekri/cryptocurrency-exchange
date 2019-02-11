package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;
import java.util.List;

public class CryptocurrencyBank {
    private final List<String> supportedCryptoCurrencies = new ArrayList<>();
    private List<Customer> sellers = new ArrayList<>();
    private List<Customer> buyers = new ArrayList<>();
    private int price = 1;

    public void addSupportedCryptoCurrency(String currency) {
        supportedCryptoCurrencies.add(currency);
    }

    public int requestTransaction(Customer buyerCustomer, int ammount, String currency) {
        int selledQuantity = 0;
        if (!sellers.isEmpty()) {
            for (Customer seller : sellers) {
                if (seller.hasCurrency(currency)) {
                    selledQuantity += makeSell(seller, buyerCustomer, ammount, currency);
                    ammount -= selledQuantity;
                    if (ammount == 0) break;
                }
            }
        }
        return selledQuantity;
    }

    private int makeSell(Customer seller, Customer buyerCustomer, int ammount, String currency) {
        buyers.add(buyerCustomer);
        price = buyers.size() == 1 ? 1 : (int) Math.pow(buyers.size(), 2) - buyers.size();
        seller.selle(ammount, price);
        buyerCustomer.buy(ammount, currency, price);
        return ammount;
    }

    public void addSeller(Customer sellerCustomer) {
        sellers.add(sellerCustomer);
    }
}
