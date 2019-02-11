package com.indev.cryptocurrency.exchange;

import java.util.HashSet;
import java.util.Set;

public class Market {
    private static Set<Customer> customers = new HashSet<>();
    public static void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public static int buy(Customer buyerCustomer, int quantity, String currency) {
        int broughtQuantity = 0;
        for(Customer customer : customers){
            if(customer.wallet.get(currency) !=null && customer.wallet.get(currency) >= quantity)
            {
                int avaibleQuantity = customer.wallet.get(currency);
                broughtQuantity = quantity;
                customer.wallet.put(currency,avaibleQuantity-broughtQuantity);
                customer.wallet.put("$",quantity);
                buyerCustomer.wallet.put(currency,broughtQuantity);
                buyerCustomer.wallet.put("$",buyerCustomer.wallet.get("$")-broughtQuantity);
                break;
            }
        }
        return broughtQuantity;
    }
}
