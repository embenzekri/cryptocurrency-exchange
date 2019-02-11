package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;

public class CryptocurrencyBank {
    private ArrayList<String> currencies = new ArrayList<>();
    private ArrayList<Customer> sellerCustomers = new ArrayList<>();
    private int numberOfTran =1;

    public void addSupportedCryptoCurrency(String currency) {
        currencies.add(currency);
    }

    public int requestTransaction(Customer buyerCustomer, int amount, String currency) {
        if (numberOfTran == 1){
            if (sellerCustomers.size() != 0){
                if(sellerCustomers.get(0).wallet.containsKey(currency)){
                    sellerCustomers.get(0).withBalance(amount);
                    sellerCustomers.get(0).withCryptocurrency(currency,sellerCustomers.get(0).wallet.get(currency)-amount);

                    buyerCustomer.withBalance(buyerCustomer.wallet.get("$")-amount);
                    buyerCustomer.withCryptocurrency(currency,amount);

                    numberOfTran++;
                    return amount;
                }
                return 0;
            }
        }else {
            if (sellerCustomers.size() != 0){
                if(sellerCustomers.get(0).wallet.containsKey(currency)){
                    sellerCustomers.get(0).withBalance(sellerCustomers.get(0).wallet.get("$")+(int)(Math.pow(numberOfTran,2)-numberOfTran)*amount);
                    sellerCustomers.get(0).withCryptocurrency(currency,sellerCustomers.get(0).wallet.get(currency)-amount);

                    buyerCustomer.withBalance(buyerCustomer.wallet.get("$")-((int)(Math.pow(numberOfTran,2)-numberOfTran)*amount));
                    buyerCustomer.withCryptocurrency(currency,amount);

                    numberOfTran++;
                    return amount;
                }
                return 0;
            }
        }
        return 0;
    }

    public void addSeller(Customer sellerCustomer) {
        sellerCustomers.add(sellerCustomer);
    }
}
