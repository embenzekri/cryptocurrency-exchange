package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

public class CryptocurrencyBank {
    private  int count=1;
    private  int count2=1;
  private List supportedCryptoCurrency=new ArrayList<String>();
ArrayList<Customer> sellers=new ArrayList<Customer>();
    public void addSupportedCryptoCurrency(String bitcoin) {
        if(!supportedCryptoCurrency.contains(bitcoin))
        supportedCryptoCurrency.add(bitcoin);
        
    }

    public int requestTransaction(Customer buyerCustomer, int i, String bitcoin) {
       int j=0;

       Customer  seller=new Customer();
        Customer  buyer=new Customer();
        if(sellers.isEmpty())
        return j;
        else {

            for (int k=0;k<sellers.size();k++)
            {
               if(  sellers.get(k).getCurrencies().containsKey(bitcoin)){
                   j=i;
                   seller=sellers.get(k);
               }

            }

            if(j==i)
            {
                 seller.setNbrDollar(i);
               seller.setCurrencieForSeller(  bitcoin,i,count);
               count++;
            }

            for (int k=0;k<sellers.size();k++)
            {
                if(  sellers.get(k).getCurrencies().containsKey(bitcoin)){
                    j=i;

                    buyerCustomer.setCurrencieForBuyer(bitcoin,i,count2);
                    count2++;
                    System.out.println("in bank "+buyerCustomer.getNbrDollar());

                }

            }

        }
        return j;
    }

    public void addSeller(Customer sellerCustomer) {
        sellers.add(sellerCustomer);
    }
}
