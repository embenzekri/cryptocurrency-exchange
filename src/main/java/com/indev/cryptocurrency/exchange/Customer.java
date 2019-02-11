package com.indev.cryptocurrency.exchange;

public class Customer {
    private String cryptocurrencyName;
    private int dolars;
    private int numberOfCurrency;



        public Customer withCryptocurrency(String CryptoName, int numberOfCryppto) {
        numberOfCurrency = numberOfCryppto;
        cryptocurrencyName =CryptoName;
        return this;
    }


    public Customer withBalance(int Balance) {
        dolars=Balance;
        return this;
    }

    @Override
    public String toString() {
        String result =dolars+":$";
        if (numberOfCurrency>0)
            result+= ","+numberOfCurrency+":"+ cryptocurrencyName;
        return result;

    }
        public boolean haveEnoughQuantity(int qantity){
            return numberOfCurrency>=qantity;
        }
        public boolean haveTheSameCryptocurrency(String cryptoName){
            return cryptocurrencyName.equals(cryptoName);
        }
        void addDolars(int quantity){
            dolars+=quantity;
        }
        void substructDolars(int quantity){
            dolars-=quantity;
        }
        void addCrypto(int quantity, String cryptoName){
            cryptocurrencyName=cryptoName;
            numberOfCurrency+=quantity;
        }
        void substructCrypto(int quantity){
            numberOfCurrency-=quantity;
        }


    }
