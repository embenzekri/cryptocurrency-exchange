package com.indev.cryptocurrency.exchange;

import com.indev.cryptocurrency.exchange.factory.WalletFactory;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    public static  final String BALANCE="$";
    public static  final int INIT_BALANCE=0;
    public  static final String WALLET_SEPARATOR=":";
    public static  final String SEPARATOR=",";
    WalletFactory walletFactory=new WalletFactory();
    private Map<String,Wallet> customerWallet=new HashMap<>();
    Customer(){
     initWallet();
    }
    public void initWallet(){
        customerWallet.put(BALANCE,walletFactory.createWallet(BALANCE,INIT_BALANCE));
    }
    public Customer withCryptocurrency(String bitcoin, int quantity) {
        customerWallet.put(bitcoin,walletFactory.createWallet(bitcoin,quantity));
        return this;
    }

    public Customer withBalance(int balanceQuantity) {
        Wallet wallet=customerWallet.get(BALANCE);
        wallet.setQuantity(balanceQuantity);
        return this;
    }

    @Override
    public String toString() {
        String customerWalletString="";
        for (Wallet wallet:customerWallet.values()){
            customerWalletString+=wallet.getQuantity()+""+WALLET_SEPARATOR+""+wallet.getName();
            customerWalletString+=SEPARATOR;
        }
        customerWalletString=customerWalletString.substring(0,customerWalletString.length()-1);
        return  customerWalletString;
    }

    public Map<String, Wallet> getCustomerWallet() {
        return customerWallet;
    }

    public void setCustomerWallet(Map<String, Wallet> customerWallet) {
        this.customerWallet = customerWallet;
    }
}
