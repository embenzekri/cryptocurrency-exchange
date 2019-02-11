package com.indev.cryptocurrency.exchange;

import java.util.List;

public class Customer {

    private CryptoCurrency cryptoCurrency ;
    private int wallet ;


    public Customer withCryptocurrency(String bitcoin, int wallet) {
        cryptoCurrency = new CryptoCurrency(bitcoin,wallet);
        return this;
    }


    public Customer withBalance(int wallet) {
        this.wallet = wallet ;
        return this;
    }

    @Override
    public String toString() {
        if (cryptoCurrency != null)
            return wallet+":$,"+cryptoCurrency;
            return wallet+":$";

    }

    public void decreaseSolde(int soldeToDecrease){
        if (wallet < soldeToDecrease)
            return;
        wallet -=soldeToDecrease;
    }

    public void increaseSolde(int soldeToDecrease){
        wallet +=soldeToDecrease;
    }

    public void decreaseCryptocurrency(int cryptoSous){
        cryptoCurrency.decreaseSolde(cryptoSous);
    }

    public String getCryptoCurrency() {
        return cryptoCurrency.getName();
    }
}
