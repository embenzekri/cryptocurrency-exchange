package com.indev.cryptocurrency.exchange;

import java.util.*;

public class CryptocurrencyBank {

    Set<String> suportedCryptoCurrency;
    List<Customer> buyers;
    List<Customer> sellers;

    public CryptocurrencyBank() {
        this.suportedCryptoCurrency=new HashSet<>();
        buyers=new ArrayList<Customer>();
        sellers=new ArrayList<Customer>();
    }

    public void addSupportedCryptoCurrency(String cryptoCurrency) {
        suportedCryptoCurrency.add(cryptoCurrency);
    }

    public int requestTransaction(Customer buyerCustomer, int i, String bitcoin) {
        if (sellers.isEmpty())
            return 0;
        return 0;
    }

    public void addSeller(Customer sellerCustomer) {
    }
}
