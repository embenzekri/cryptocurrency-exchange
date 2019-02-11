package com.indev.cryptocurrency.exchange;

import java.util.HashSet;
import java.util.Set;

public class Market {
    private  Set<Customer> sellers = new HashSet<>();
    private  Set<Customer> buyers = new HashSet<>();
    private int price = 1 ;
    public  int buy(Customer buyerCustomer, int quantity, String currency) {
        int broughtQuantity = 0;
        for(Customer seller : sellers)
        {
           if(seller.wallet.get(currency) != null && seller.wallet.get(currency) >= quantity)
           {
               seller.updateSeller(price,quantity,currency);
               buyerCustomer.updateBuyer(price,quantity,currency);
               broughtQuantity = quantity;
               break;
           }
        }
        return broughtQuantity;
    }

    public void addBuyer(Customer customer) {
        buyers.add(customer);
        price = buyers.size()*buyers.size()-buyers.size();
        if(price == 0)
            price =1;
    }

    public void addSeller(Customer customer) {
        sellers.add(customer);
    }
}
