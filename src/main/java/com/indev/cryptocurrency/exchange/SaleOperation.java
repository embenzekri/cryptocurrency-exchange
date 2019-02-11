package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SaleOperation {





    public static int calculSaleQuantity(HashMap<String, List<Customer>> customersByCryptoCurrency,Customer buyerCustomer ,int quantityCryptoCurrency, String cryptoCurrency) {
        if( !checkIfSellersExists(customersByCryptoCurrency,quantityCryptoCurrency,cryptoCurrency)) return 0;
        else {
            buyerCustomer.reduceBalance(quantityCryptoCurrency);
            buyerCustomer.withCryptocurrency(cryptoCurrency,quantityCryptoCurrency);
            customersByCryptoCurrency.get(cryptoCurrency);
            return quantityCryptoCurrency;
        }
    }

    public static boolean checkIfSellersExists(HashMap<String, List<Customer>> customersByCryptoCurrency, int quantity,String cryptoCurrency){

       if(customersByCryptoCurrency.get(cryptoCurrency)==null) return false;
       else
           return true;

    }
}
