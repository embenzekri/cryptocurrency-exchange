package com.indev.cryptocurrency.exchange;

import java.util.*;

public class CryptocurrencyBank {

    Set<String> suportedCryptoCurrency;
    int buyersNumber;
    List<Customer> sellers;

    public CryptocurrencyBank() {
        this.suportedCryptoCurrency=new HashSet<>();
        buyersNumber=0;
        sellers=new ArrayList<Customer>();
    }

    public void addSupportedCryptoCurrency(String cryptoCurrency) {
        suportedCryptoCurrency.add(cryptoCurrency);
    }

    public int requestTransaction(Customer buyerCustomer, int amount, String cryptocurrency) {
        buyersNumber++;
        if (sellers.isEmpty()){
            return 0;
        }
        Optional<Customer> seller=getSeller(cryptocurrency,amount);
        if (seller.isPresent()){
            seller.get().reduceCryptocurrencyBalance(amount).addBalance(amount*getCryptocurrencyValue());
            buyerCustomer.reduceBalance(amount*getCryptocurrencyValue());
            if (buyerCustomer.hasCryptocurencyBalance())
                buyerCustomer.addCryptocurrencyBalance(amount);
            else
                buyerCustomer.withCryptocurrency(cryptocurrency,amount);
            return amount;
        }else
            return 0;
    }

    private Optional<Customer> getSeller(String cryptocurrency,Integer amount){
         return this.sellers.stream().filter(costumer->(costumer.hasEnaughBalanceToSell(amount) && costumer.hasCryptocurency(cryptocurrency))).findFirst();
    }

    public void addSeller(Customer sellerCustomer) {
        this.sellers.add(sellerCustomer);
    }

    private Integer getCryptocurrencyValue(){
        if (buyersNumber==0 || buyersNumber==1){
            return 1;
        }else
            return buyersNumber*buyersNumber-buyersNumber;
    }
}
