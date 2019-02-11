package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;
import java.util.List;

public class CryptocurrencyBank {

    private List<String> supportedCryptoCurrency = new ArrayList<String>();
    private Customer seller  ;
    private int countBuyer = 1 ;
    public void addSupportedCryptoCurrency(String bitcoin) {
        supportedCryptoCurrency.add(bitcoin);
    }

    public int requestTransaction(Customer buyerCustomer, int i, String bitcoin) {
        if (seller == null || isCryptoCurrencySeller(bitcoin)){
            return 0;
        }

        int add = countBuyer*countBuyer - countBuyer;
        if (add == 0)
            add=1;

        buyerCustomer.withCryptocurrency(bitcoin,i);
        buyerCustomer.decreaseSolde(i*add);

        seller.increaseSolde(i*add);
        seller.decreaseCryptocurrency(i);
        countBuyer++;
        return i;
    }

    public boolean isCryptoCurrencySeller(String bitcoin){
        if (seller.getCryptoCurrency().equals(bitcoin))
            return  false;
        return true ;
    }

    public void addSeller(Customer sellerCustomer) {
        seller = sellerCustomer;
    }
}
