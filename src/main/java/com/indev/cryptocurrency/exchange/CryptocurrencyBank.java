package com.indev.cryptocurrency.exchange;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
class CryptocurrencyBank {

    private static final int FIRST_BUYER = 1;
    private List<String> supportedCryptoCurrencies = new LinkedList<>();
    private List<Customer> sellers = new ArrayList<>();
    private int buyersNumber;

    void addSupportedCryptoCurrency(String supportedCryptoCurrencey) {
        this.supportedCryptoCurrencies.add(supportedCryptoCurrencey);
    }

    int requestTransaction(Customer buyerCustomer, int requestCryptoBalance, String cryptoCurrencey) {
        int soldCryptocurrency = 0;
        if(isCryptocurrencySupported(cryptoCurrencey)){
            soldCryptocurrency = doTransaction(buyerCustomer, requestCryptoBalance, cryptoCurrencey);
        }
        return soldCryptocurrency;
    }

    private boolean isCryptocurrencySupported(String cryptoCurrencey) {
        return supportedCryptoCurrencies.contains(cryptoCurrencey);
    }

    private int doTransaction(Customer buyerCustomer, int requestCryptoBalance, String cryptoCurrencey) {
        Optional<Customer> sellerCustomer = findSellerWithCryptocurrency(cryptoCurrencey);

        int soldCryptocurrency = 0;

        if(sellerCustomer.isPresent() && sellerCustomer.get().canSell() ){

            incrementBuyers();

            int cryptoSellingPrice = recalculateCryptoSellingPrice() * requestCryptoBalance;

            sellerCustomer.get().sell(requestCryptoBalance, cryptoSellingPrice);

            buyerCustomer.withCryptocurrency(cryptoCurrencey,0);
            buyerCustomer.buy(requestCryptoBalance, cryptoSellingPrice);

            soldCryptocurrency = requestCryptoBalance;
        }

        return soldCryptocurrency;
    }

    private void incrementBuyers() {
        buyersNumber++;
    }

    private int recalculateCryptoSellingPrice() {
        if (buyersNumber== FIRST_BUYER) return 1;
        return buyersNumber*buyersNumber - buyersNumber;
    }

    private Optional<Customer> findSellerWithCryptocurrency(String cryptoCurrencey) {
        return sellers.stream().filter(customer -> customer.isSellingCryptocurrency(cryptoCurrencey)).findFirst();
    }

    void addSeller(Customer sellerCustomer) {
        sellers.add(sellerCustomer);
    }

     List<String> getSupportedCryptoCurrencies() {
        return supportedCryptoCurrencies;
    }

    void deleteSupportedCryptoCurrency(String cryptocurrencyName) {
        supportedCryptoCurrencies.remove(cryptocurrencyName);
    }
}
