package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;
import java.util.List;

public class CryptocurrencyBank {
    private final List<String> supportedCryptoCurrencies = new ArrayList<>();
    private List<Customer> sellers = new ArrayList<>();
    private int buyerRank = 0;

    public void addSupportedCryptoCurrency(String currency) {
        supportedCryptoCurrencies.add(currency);
    }

    public int requestTransaction(Customer buyerCustomer, int ammount, String currency) {
        if (!sellers.isEmpty()) {
            return doTransaction(buyerCustomer, ammount, currency);
        }
        return 0;
    }

    private int doTransaction(Customer buyerCustomer, int ammount, String currency) {
        int selledQuantity = 0;
        for (Customer seller : sellers) {
            if (seller.hasCurrency(currency)) {
                selledQuantity += makeSell(seller, buyerCustomer, ammount, currency);
                ammount -= selledQuantity;
                if (ammount == 0) break;
            }
        }
        return selledQuantity;
    }

    private int makeSell(Customer seller, Customer buyerCustomer, int ammount, String currency) {
        buyerRank++;
        seller.selle(ammount, currentPrice());
        buyerCustomer.buy(ammount, currency, currentPrice());
        return ammount;
    }
    private int currentPrice(){
        return buyerRank == 1 ? 1 : (int) Math.pow(buyerRank, 2) - buyerRank;
    }

    public void addSeller(Customer sellerCustomer) {
        sellers.add(sellerCustomer);
    }
}
