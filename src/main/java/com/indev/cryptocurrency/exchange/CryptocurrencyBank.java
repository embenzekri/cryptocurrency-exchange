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
        if(buyerCustomer.getBalance() <= cryptoCurrencyAmount)
            return 0;
        for(Customer sellerCustomer: sellers){
            if(sellerCustomer.getCryptoCurrencyAmount() > cryptoCurrencyAmount && sellerCustomer.getCryptoCurrency().equals(cryptoCurrency)){
                return makeTransaction(buyerCustomer, sellerCustomer, cryptoCurrencyAmount, cryptoCurrency);
            }
        }

        return 0;
    }

    private int makeTransaction(Customer buyerCustomer, Customer sellerCustomer, int cryptoCurrencyAmount, String cryptoCurrency) {
        sellerCustomer.setCryptoCurrencyAmount(sellerCustomer.getCryptoCurrencyAmount() - cryptoCurrencyAmount);
        sellerCustomer.setBalance(sellerCustomer.getBalance() + cryptoCurrencyAmount*cryptoCurrencyPrice );

        buyerCustomer.setCryptoCurrencyAmount(buyerCustomer.getCryptoCurrencyAmount() + cryptoCurrencyAmount);
        buyerCustomer.setBalance(buyerCustomer.getBalance() - cryptoCurrencyAmount*cryptoCurrencyPrice );
        buyerCustomer.setCryptoCurrency(cryptoCurrency);


        addBuyer(buyerCustomer);

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

        int numberOfBuyers = buyers.size() + 1;
        cryptoCurrencyPrice = (numberOfBuyers * numberOfBuyers) - numberOfBuyers;
        System.out.println(cryptoCurrencyPrice);
    }


}
