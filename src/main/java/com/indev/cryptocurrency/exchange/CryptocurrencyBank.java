package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CryptocurrencyBank {

    private String supportedCryptoCurrencey;
    private List<Customer> sellers = new ArrayList<>();
    private int buyersNumber;

    public void addSupportedCryptoCurrency(String supportedCryptoCurrencey) {
        this.supportedCryptoCurrencey = supportedCryptoCurrencey;
    }

    public int requestTransaction(Customer buyerCustomer, int requestCryptoBalance, String cryptoCurrencey) {
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
        if (buyersNumber==1) return 1;
        return buyersNumber*buyersNumber - buyersNumber;
    }

    private Optional<Customer> findSellerWithCryptocurrency(String cryptoCurrencey) {
        return sellers.stream().filter(customer -> customer.isSellingCryptocurrency(cryptoCurrencey)).findFirst();
    }

    public void addSeller(Customer sellerCustomer) {
        sellers.add(sellerCustomer);
    }
}
