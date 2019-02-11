package com.indev.cryptocurrency.exchange;

public class Walette{


    private String cryptocurrencyName;
    private int cryptocurrencyBalance;

    public Walette(String cryptocurrencyName, int cryptocurrencyBalance) {

        this.cryptocurrencyName = cryptocurrencyName;
        this.cryptocurrencyBalance = cryptocurrencyBalance;
    }

    @Override
    public String toString() {
        return cryptocurrencyBalance + ":" + cryptocurrencyName;
    }

    public Walette(String cryptoName) {
        this.cryptocurrencyName = cryptoName;
    }

    public boolean hasCryptocurrency(String cryptocurrencyName) {
        return cryptocurrencyName.equals(this.cryptocurrencyName);
    }

    public void addCryptocurrencyBalance(int boughtCryptoAmount) {
        this.cryptocurrencyBalance += boughtCryptoAmount;
    }

    public void reduceCryptocurrencyBalance(int soldeCryptoAmount) {
        this.cryptocurrencyBalance -= soldeCryptoAmount;
    }
}
