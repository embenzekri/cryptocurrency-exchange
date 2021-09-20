package com.indev.cryptocurrency.exchange;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class CryptocurrencyBank {

    private final Set<String> currencies = new HashSet<>();
    private final Set<Customer> sellers = new HashSet<>();
    private int buyingCounter = 0;

    public void addSupportedCryptoCurrency(String bitcoin) {
        currencies.add(bitcoin);
    }

    public int requestTransaction(Customer buyerCustomer, int i, String bitcoin) {
        Optional<Customer> seller =
                sellers.stream().filter(s -> s.getCurrency().equals(bitcoin)).findFirst();
        if (seller.isPresent()) {
            buyingCounter++;
            int price = calcPrice();
            seller.get().sell(i, price);
            buyerCustomer.buy(i, price, bitcoin);
            return i;
        }
        return 0;
    }

    private int calcPrice() {
        return  buyingCounter > 1 ?
                buyingCounter * buyingCounter - buyingCounter : 1;
    }

    public void addSeller(Customer sellerCustomer) {
        sellers.add(sellerCustomer);
    }
}
