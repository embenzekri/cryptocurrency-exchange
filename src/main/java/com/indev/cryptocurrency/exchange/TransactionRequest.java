package com.indev.cryptocurrency.exchange;

public class TransactionRequest {

    private int cryptoPrice;
    private int cryptoAmount;
    private String cryptoName;
    private Customer buyer;

    private TransactionRequest(int cryptoPrice, int cryptoAmount, String cryptoName, Customer buyer) {

        this.cryptoPrice = cryptoPrice;
        this.cryptoAmount = cryptoAmount;
        this.cryptoName = cryptoName;
        this.buyer = buyer;
    }

    public static TransactionRequest makeTransaction(int cryptoPrice, int cryptoAmount, String cryptoName, Customer buyer){
        return new TransactionRequest(cryptoPrice, cryptoAmount, cryptoName, buyer);
    }

    public int getCryptoPrice() {
        return cryptoPrice;
    }

    public int getCryptoAmount() {
        return cryptoAmount;
    }

    public String getCryptoName() {
        return cryptoName;
    }

    public Customer getBuyer() {
        return buyer;
    }
}
