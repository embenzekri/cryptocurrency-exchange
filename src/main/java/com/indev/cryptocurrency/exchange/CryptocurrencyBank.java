package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CryptocurrencyBank {
    List<Customer> sellers = new ArrayList<>();
    List<Customer> buyers = Collections.synchronizedList(new ArrayList<>());
    private int cryptoCurrencyPrice;

    public void addSupportedCryptoCurrency(String bitcoin) {
        
    }

    public int requestTransaction(Customer buyerCustomer, int cryptoCurrencyAmount, String cryptoCurrency) {
        for(Customer sellerCustomer: sellers){
                return makeTransaction(buyerCustomer, sellerCustomer, cryptoCurrencyAmount, cryptoCurrency);
        }

        return 0;
    }

    private int makeTransaction(Customer buyerCustomer, Customer sellerCustomer, int cryptoCurrencyAmount, String cryptoCurrency) {
        addBuyer(buyerCustomer);

        sellerCustomer.setCryptoCurrencyAmount(sellerCustomer.getCryptoCurrencyAmount() - cryptoCurrencyAmount);
        sellerCustomer.setBalance(sellerCustomer.getBalance() + cryptoCurrencyAmount * cryptoCurrencyPrice );

        buyerCustomer.setCryptoCurrencyAmount(buyerCustomer.getCryptoCurrencyAmount() + cryptoCurrencyAmount);
        buyerCustomer.setBalance(buyerCustomer.getBalance() - cryptoCurrencyAmount * cryptoCurrencyPrice );
        buyerCustomer.setCryptoCurrency(cryptoCurrency);

        return cryptoCurrencyAmount;
    }

    public void addSeller(Customer sellerCustomer) {
        sellers.add(sellerCustomer);
    }
    public void addBuyer(Customer buyerCustomer){
        buyers.add(buyerCustomer);
        updateCryptoCurrencyRate();
    }

    private void updateCryptoCurrencyRate(){
        if(buyers.size() == 1){
            cryptoCurrencyPrice = 1;
            return;
        }
        int numberOfBuyers = buyers.size();
        cryptoCurrencyPrice = (numberOfBuyers * numberOfBuyers) - numberOfBuyers;
    }


}
