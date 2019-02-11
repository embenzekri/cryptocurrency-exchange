package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CryptocurrencyBank {

    private String supportedCryptoCurrencey;
    private List<Customer> sellers = new ArrayList<>();

    public void addSupportedCryptoCurrency(String supportedCryptoCurrencey) {
        this.supportedCryptoCurrencey = supportedCryptoCurrencey;
    }

    public int requestTransaction(Customer buyerCustomer, int requestCryptobalance, String cryptoCurrencey) {
        Optional<Customer> sellerCustomer = findSellerWithCryptocurrency(cryptoCurrencey);
        int soldCryptocurrency = 0;

        if(sellerCustomer.isPresent() && sellerCustomer.get().canSell()){
            sellerCustomer.get().sell(requestCryptobalance);
            buyerCustomer.buy(requestCryptobalance);

            soldCryptocurrency = requestCryptobalance;
        }

        return soldCryptocurrency;
    }

    private Optional<Customer> findSellerWithCryptocurrency(String cryptoCurrencey) {
        return sellers.stream().filter(customer -> customer.isSellingCryptocurrency(cryptoCurrencey)).findFirst();
    }

    public void addSeller(Customer sellerCustomer) {
        sellers.add(sellerCustomer);
    }
}
