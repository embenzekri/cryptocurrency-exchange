package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;
import java.util.List;

public class CryptocurrencyBank {

    private List<String> cryptoCurrency = new ArrayList<>() ;
    private int valueOfCurrency = 1 ;
     List<Customer> sellers = new ArrayList<>() ;
    private List<Customer> buyers = new ArrayList<>() ;
    public void addSupportedCryptoCurrency(String bitcoin) {

        cryptoCurrency.add(bitcoin) ;
    }
    public int requestTransaction(Customer customer, int quantite, String cryptoCurrency) {
        customer.setCryptoCurrency(cryptoCurrency);
        buyers.add(customer) ;
        if(isNoSeller()) return 0 ;
                List<Customer> sellerWithEnoughCurrency =  getSellerWithEnoughCurrency(quantite,cryptoCurrency);
                if(sellerWithEnoughCurrency.isEmpty())
                {
                    return 0 ;
                }else
                {
                    changeValueOfCryptoCurrency(buyers) ;
                    setChangesToCustomerAndBuyer(sellerWithEnoughCurrency.get(0),customer,quantite) ;
                    return quantite ;
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

    private List<Customer> getSellerWithEnoughCurrency(int quantite,String cryptoCurrency) {
        List<Customer> sellersLigible = new ArrayList<>() ;
        for(Customer seller:sellers){
            if(seller.getAmountCryptoCurrency() >= quantite && seller.getCryptoCurrency().equals(cryptoCurrency)){
                sellersLigible.add(seller);
            }
        }
         return sellersLigible ;
    }
    private boolean isNoSeller() {
        return sellers.isEmpty() ;
    }
    public void addSeller(Customer sellerCustomer) {
        sellers.add(sellerCustomer) ;
    }
}
