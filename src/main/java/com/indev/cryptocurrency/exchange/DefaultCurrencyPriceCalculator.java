package com.indev.cryptocurrency.exchange;

public class DefaultCurrencyPriceCalculator implements CurrencyPriceCalculator {

    int buyersCounter;

    @Override
    public int getCurrencyPrice(int currencyPrice) {
        return ++buyersCounter > 1
                ? currencyPrice * ( (buyersCounter * buyersCounter) - buyersCounter)
                :currencyPrice;
    }

    public void incrementBuy(){
        ++buyersCounter;
    }
}
