package com.indev.cryptocurrency.exchange;

import java.util.List;

public class Customer {

    private CryptoCurrency cryptoCurrency ;
    private int solde ;


    public Customer withCryptocurrency(String bitcoin, int i) {
        cryptoCurrency = new CryptoCurrency(bitcoin,i);
        return this;
    }


    public Customer withBalance(int i) {
        solde = i ;
        return this;
    }

    @Override
    public String toString() {
        if (cryptoCurrency != null)
            return solde+":$,"+cryptoCurrency;
            return solde+":$";

    }

    public void decreaseSolde(int soldeToDecrease){
        if (solde < soldeToDecrease)
            return;
        solde -=soldeToDecrease;
    }

    public void increaseSolde(int soldeToDecrease){
        solde +=soldeToDecrease;
    }

    public void increaseCryptocurrency(int cryptoAdd){
        cryptoCurrency.increaseSolde(cryptoAdd);
    }
    public void decreaseCryptocurrency(int cryptoSous){
        cryptoCurrency.decreaseSolde(cryptoSous);
    }

    public String getCryptoCurrency() {
        return cryptoCurrency.getName();
    }
}
