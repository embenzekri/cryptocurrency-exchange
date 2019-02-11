package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;
import java.util.List;

public class CryptocurrencyBank{

    private List<String> supportedCryptoCurrency = new ArrayList<>();
    private List<AbstractCustomer> cryptocurrencySellers = new ArrayList<>();

    private CurrencyPriceCalculator priceCalculator = new DefaultCurrencyPriceCalculator();

    public void addSupportedCryptoCurrency(String cryptoCurrencyName) {
        supportedCryptoCurrency.add(cryptoCurrencyName);
    }

    public int requestTransaction(Customer buyer, int cryptoAmount, String cryptoName) {
        AbstractCustomer seller = getSellerByCryptoName(cryptoName);
        int cryptoPriceByBuyersNumber = priceCalculator.getCurrencyPrice(cryptoAmount);

        seller.doTransaction(TransactionRequest
                .makeTransaction(cryptoPriceByBuyersNumber, cryptoAmount,cryptoName,buyer));
        return cryptoAmount;
    }

    private AbstractCustomer getSellerByCryptoName(String cryptoName) {
        return cryptocurrencySellers.stream()
                .filter(seller -> seller.hasCryptocurrency(cryptoName))
                .findFirst()
                .orElse(new NullCustomer());
    }


    void addSeller(Customer sellerCustomer) {
        cryptocurrencySellers.add(sellerCustomer);
    }
}
