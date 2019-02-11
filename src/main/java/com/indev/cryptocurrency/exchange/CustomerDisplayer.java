package com.indev.cryptocurrency.exchange;



public class CustomerDisplayer {
    public static String displayCustomer(Customer customer){

        String displayCustomer = customer.getBalance()+":$";
        for(String currentCryptoCurrency : customer.getCryptocurrencies().keySet()){
            displayCustomer+=","+customer.getCryptocurrencies().get(currentCryptoCurrency)+":"+currentCryptoCurrency;
        }
        return displayCustomer;
    }
}
