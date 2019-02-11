package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;
import java.util.HashMap;

public class CryptocurrencyBank {

    HashMap<String, ArrayList<Customer>> customersByCryptoCurrency = new HashMap<>();
    ArrayList<Customer> customers = new ArrayList<>();
    ArrayList<Customer> sellerCustomers = new ArrayList<>();

    public void addSupportedCryptoCurrency(String cryptoCurrency) {
        customersByCryptoCurrency.put(cryptoCurrency,null);
    }

    public int requestTransaction(Customer customer, int quantity, String bitcoin) {
        if(sellerCustomers.size()==0)
            return  0;
       return 1;
    }

    public void addSeller(Customer sellerCustomer) {
        sellerCustomers.add(sellerCustomer);
    }
}
