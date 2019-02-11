package com.indev.cryptocurrency.exchange.factory;

import com.indev.cryptocurrency.exchange.Wallet;

public class WalletFactory {
    public Wallet createWallet(String cryptoCurrency, int walletQauntity){
        return new Wallet(cryptoCurrency,walletQauntity);
    }
}
