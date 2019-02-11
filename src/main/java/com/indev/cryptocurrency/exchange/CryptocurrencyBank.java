package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CryptocurrencyBank {

    HashMap<String, List<Customer>> sellersCustomersByCryptoCurrency = new HashMap<>();
    List<Customer> sellersCustomers = new ArrayList<>();




    public void addSupportedCryptoCurrency(String cryptoCurrency) {
        sellersCustomersByCryptoCurrency.put(cryptoCurrency,null);
    }

    public int requestTransaction(Customer customer, int quantity, String cryptoCurrency) {


        return SaleOperation.calculSaleQuantity(sellersCustomersByCryptoCurrency,customer,quantity,cryptoCurrency);
    }

    public void addSeller(Customer sellerCustomer) {

        sellersCustomers.add(sellerCustomer);
        sellersCustomersByCryptoCurrency.replace(sellerCustomer.getCryptoCurrency(),sellersCustomers);
    }
}
