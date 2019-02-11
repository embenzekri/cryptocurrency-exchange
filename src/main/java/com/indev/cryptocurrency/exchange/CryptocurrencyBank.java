package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;

public class CryptocurrencyBank {
    ArrayList<String> supportedCryptoCurrency;
    ArrayList<Customer> sellers;
    Integer buyersQueue = 1;

    public void addSupportedCryptoCurrency(String currency) {
        if (isExistSupportedCryptoCurrency()) {
            supportedCryptoCurrency.add(currency);
        } else {
            initSupportedCryptoCurrency();
            addSupportedCryptoCurrency(currency);
        }
    }

    public int requestTransaction(Customer buyerCustomer, int amount, String currency) {
        if (!isExistSeller()) return 0;
        if (sellers.get(0).isExistCurrency(currency)) {
            if (buyerCustomer.isExistCurrency(currency)) {
                buyerCustomer.currenciesSolde.replace(currency, buyerCustomer.currenciesSolde.get(currency) + amount);
            } else buyerCustomer.currenciesSolde.put(currency, amount);
            buyerCustomer.currenciesSolde.replace("$", buyerCustomer.currenciesSolde.get("$") - amount*mecalfeLawQueue(buyersQueue));

            sellers.get(0).currenciesSolde.replace(currency, sellers.get(0).currenciesSolde.get(currency) - amount);
            sellers.get(0).currenciesSolde.replace("$", sellers.get(0).currenciesSolde.get("$") + amount*mecalfeLawQueue(buyersQueue));
            buyersQueue ++;
            return amount;
        } else return 0;
    }

    public void addSeller(Customer sellerCustomer) {
        initSellers();
        sellers.add(sellerCustomer);
    }

    private boolean isExistSupportedCryptoCurrency() {
        return supportedCryptoCurrency != null;
    }

    private void initSupportedCryptoCurrency() {
        supportedCryptoCurrency = new ArrayList<>();
    }

    private void initSellers() {
        if (!isExistSeller()) sellers = new ArrayList<>();
    }

    boolean isExistSeller() {
       return sellers != null;
    }
    Integer mecalfeLawQueue(int queue){
        if (queue==1) return 1;
        return (queue*queue)- queue; }
}
