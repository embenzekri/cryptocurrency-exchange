package com.indev.cryptocurrency.exchange.api.cryptocurrency;

import com.indev.cryptocurrency.exchange.Customer;
import com.indev.cryptocurrency.exchange.Wallet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CryptocurrencyBank {
    int numberOfBuyer=0;
    List<Customer> sellerCustomers=new ArrayList<>();
    List<String> supportedCryptoCurrency=new ArrayList<>();
    public void addSupportedCryptoCurrency(String bitcoin) {
        supportedCryptoCurrency.add(bitcoin);
    }

    public int requestTransaction(Customer buyerCustomer, int quantity, String cryptoCurrency) {
      if(isSellerExist(cryptoCurrency)){
          numberOfBuyer++;
          Customer customerSeller=sellerCustomers.get(0);
          Wallet walletBalanceToUpdate=buyerCustomer.getCustomerWallet().get(Customer.BALANCE);
          Wallet wallet=buyerCustomer.getCustomerWallet().get(cryptoCurrency);
        if(wallet!=null ){
            wallet.setQuantity(wallet.getQuantity()+quantity);
        }else {
            buyerCustomer.withCryptocurrency(cryptoCurrency,quantity);
        }
        int walletBalnceToAdd=updateBalanceWallet(walletBalanceToUpdate,quantity);
        updateSellerCurrency(customerSeller,cryptoCurrency,quantity);
        updateBalanceWalletSeller(customerSeller,walletBalnceToAdd);
        return  quantity;
      }
        return 0;
    }

    public void addSeller(Customer sellerCustomer) {
        sellerCustomers.add(sellerCustomer);
    }

    private boolean isSellerExist(String cryptoCurrency){
       return (! sellerCustomers.isEmpty() && sellerCustomers.get(0).getCustomerWallet().get(cryptoCurrency) !=null);
    }
    private void updateBalanceWalletSeller(Customer sellerCustomer,int balanceToAdd){
        Wallet wallet=sellerCustomer.getCustomerWallet().get(Customer.BALANCE);
        wallet.setQuantity(wallet.getQuantity()+balanceToAdd);
    }
    private int updateBalanceWallet(Wallet wallet,int quantity){
        int updatedBalance=0;
        if(numberOfBuyer==1) {
            updatedBalance=quantity*1;
        }
        else{
            updatedBalance=((int)Math.pow(numberOfBuyer,2)-numberOfBuyer)*quantity;
        }
        wallet.setQuantity(wallet.getQuantity()-updatedBalance);
        return updatedBalance;
    }
    private void updateSellerCurrency(Customer  sellerCustomer,String cryptoCurrency,int quantity){
        Wallet wallet=sellerCustomer.getCustomerWallet().get(cryptoCurrency);
        wallet.setQuantity(wallet.getQuantity()-quantity);
    }

    public List<String> getSupportedCryptoCurrency() {
        return supportedCryptoCurrency;
    }
    public List<String> removeCryptoCurrency(String CryptoCurrency){
        this.supportedCryptoCurrency.remove(CryptoCurrency);
        return  this.supportedCryptoCurrency;
    }

}
