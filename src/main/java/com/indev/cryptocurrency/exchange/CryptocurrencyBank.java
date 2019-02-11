package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;
import java.util.List;

public class CryptocurrencyBank {

    private List<String> CryptoCurrency = new ArrayList<>() ;private int valueOfCurrency = 1 ;
     List<Customer> sellers = new ArrayList<>() ;
    private List<Customer> buyers = new ArrayList<>() ;
    public void addSupportedCryptoCurrency(String bitcoin) {

        CryptoCurrency.add(bitcoin) ;
    }

    public int requestTransaction(Customer customer, int quantite, String cryptoCurrency) {
        customer.setCryptoCurrency(cryptoCurrency);
        buyers.add(customer) ;
        if(isNoSeller()) return 0 ;
            try {
                Customer sellerWithEnoughCurrency =  getSellerWithEnoughCurrency(quantite,cryptoCurrency);
                changeValueOfCryptoCurrency(buyers) ;
                setChangesToCustomerAndBuyer(sellerWithEnoughCurrency,customer,quantite) ;
                return quantite ;
            }catch (Exception e ){
                return 0 ;
            }
    }

    private void changeValueOfCryptoCurrency(List<Customer> buyers) {
        if(buyers.size() >=2)
        {
            valueOfCurrency = buyers.size()*(buyers.size() - 1) ;
        }
    }

    private void setChangesToCustomerAndBuyer(Customer sellerWithEnoughCurrency, Customer customer,int quantite) {
        customer.setAmountCryptoCurrency(customer.getAmountCryptoCurrency()+quantite);
        customer.setAmountDollars(customer.getAmountDollars()-valueOfCurrency*quantite);
        sellerWithEnoughCurrency.setAmountDollars(sellerWithEnoughCurrency.getAmountDollars()+valueOfCurrency*quantite);
        sellerWithEnoughCurrency.setAmountCryptoCurrency(sellerWithEnoughCurrency.getAmountCryptoCurrency()-quantite);
    }

    private Customer getSellerWithEnoughCurrency(int quantite,String cryptoCurrency) throws Exception {
        for(Customer seller:sellers){
            if(seller.getAmountCryptoCurrency() >= quantite && seller.getCryptoCurrency().equals(cryptoCurrency)){
                return seller ;
            }
        }
         throw new Exception() ;
    }
    private boolean isNoSeller() {
        if( sellers.size() == 0) return true ;
        return false;
    }
    public void addSeller(Customer sellerCustomer) {
        sellers.add(sellerCustomer) ;
    }
}
