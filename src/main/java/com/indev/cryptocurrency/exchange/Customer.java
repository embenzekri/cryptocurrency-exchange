package com.indev.cryptocurrency.exchange;

public class Customer {
    public static final String DEFAULT_BALANCE_CURRENCY = "$";
    public static final String BALANCE_CURRENCY_JOINER = ":";
    public static final String BALANCES_JOINER = ",";
    private String cryptoCurrencey;
    private int cryptoBalance;
    private int balance;


    public Customer withCryptocurrency(String cryptoCurrencey, int cryptoBalance) {
        this.cryptoCurrencey = cryptoCurrencey;
        this.cryptoBalance = cryptoBalance;
        return this;
    }

    public Customer withBalance(int balance) {
        this.balance = balance;
        return this;
    }

    @Override
    public String toString() {
        String costomerToString = balanceAndCurrencyJoiner(balance, DEFAULT_BALANCE_CURRENCY);

        if(hasCryptoCurrency()){
           costomerToString +=  BALANCES_JOINER + balanceAndCurrencyJoiner(cryptoBalance, cryptoCurrencey) ;
        }

        return costomerToString;
    }

    private boolean hasCryptoCurrency() {
        return cryptoCurrencey != null;
    }


    private String balanceAndCurrencyJoiner(int balance, String currency){
        return balance + BALANCE_CURRENCY_JOINER + currency;
    }


    public boolean isSellingCryptocurrency(String cryptoCurrencey) {
        return this.cryptoCurrencey.equals(cryptoCurrencey);
    }

    public void sell(int soldCrytpo) {
        cryptoBalance -= soldCrytpo;
        balance += soldCrytpo;
    }

    public void buy(int boughtCrypto) {
        cryptoBalance += boughtCrypto;
        balance -= boughtCrypto;
    }

    public boolean canSell() {
        return cryptoBalance > 0;
    }
}
