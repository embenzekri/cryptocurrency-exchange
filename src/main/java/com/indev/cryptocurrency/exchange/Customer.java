package com.indev.cryptocurrency.exchange;

public class Customer {

    private int numberOfCryptoCurrency;
    private int balence = 0;
    private String cryptoCurrency;
    private int cryptoCurrencyPrice = 1;

    public Customer withCryptocurrency(String cryptoCurrency, int numberOfCryptoCurrency) {
        this.cryptoCurrency = cryptoCurrency;
        this.numberOfCryptoCurrency = numberOfCryptoCurrency;
        return this;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(balence).append(":$");
        if (numberOfCryptoCurrency != 0){
            result.append(",")
                    .append(numberOfCryptoCurrency)
                    .append(":")
                    .append(cryptoCurrency);
        }
        return result.toString();
    }

    public Customer withBalance(int balence) {
        this.balence = balence;
        return this;
    }

    public int transactionWith(Customer buyerCustomer, int numberOfCryptoCurrency, String cryptoCurrency, int cryptoCurrencyPrice) {
        addToSeler(numberOfCryptoCurrency,cryptoCurrency,cryptoCurrencyPrice);
        minusFromBuyer(buyerCustomer, numberOfCryptoCurrency,cryptoCurrency,cryptoCurrencyPrice);
        return numberOfCryptoCurrency;
    }

    private void minusFromBuyer(Customer buyerCustomer, int numberOfCryptoCurrency, String cryptoCurrency, int cryptoCurrencyPrice) {
        buyerCustomer.numberOfCryptoCurrency += numberOfCryptoCurrency;
        buyerCustomer.balence -= numberOfCryptoCurrency*cryptoCurrencyPrice;
        buyerCustomer.cryptoCurrency = cryptoCurrency;
    }

    private void addToSeler(int numberOfCryptoCurrency, String cryptoCurrency, int cryptoCurrencyPrice) {
        this.numberOfCryptoCurrency -= numberOfCryptoCurrency;
        this.balence += numberOfCryptoCurrency*cryptoCurrencyPrice;
        this.cryptoCurrency = cryptoCurrency;
    }



    public boolean has(String cryptoCurrency) {
        return this.cryptoCurrency.equals(cryptoCurrency);
    }
}
