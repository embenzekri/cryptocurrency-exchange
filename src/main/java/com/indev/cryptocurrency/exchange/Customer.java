package com.indev.cryptocurrency.exchange;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    Market market = new Market();
    Map<String, Integer> wallet = new HashMap<>();

    public Customer withCryptocurrency(String currency, int quantity) {
        wallet.put(currency, quantity);
        return this;
    }

    public Customer withBalance(int quantity) {
        wallet.put("$", quantity);
        return this;
    }

    @Override
    public String toString() {
        Integer ballance = wallet.get("$");
        Integer bitcoin = wallet.get("Bitcoin");
        Integer ethereum = wallet.get("Ethereum");
        String walletMessage = "";
        if (ballance == null) {
            walletMessage += 0 + ":$";
        } else {
            walletMessage += ballance + ":$";
        }
        if (bitcoin != null) {
            walletMessage += "," + bitcoin + ":Bitcoin";
        } else if (ethereum != null) {
            walletMessage += "," + ethereum + ":Ethereum";
        }
        return walletMessage;
    }

    public int buy(Customer buyerCustomer, int quantity, String currency) {
        return market.buy(buyerCustomer, quantity, currency);
    }

    public void updateSeller(int price, int quantity, String currency) {
        if (wallet.get(currency) != null) {
            this.wallet.put(currency, wallet.get(currency) - quantity);
        } else {
            this.wallet.put(currency, quantity);
        }
        if (this.wallet.get("$") != null) {
            this.wallet.put("$", this.wallet.get("$") + price * quantity);
        } else {
            this.wallet.put("$", price * quantity);

        }
    }


    public void updateBuyer(int price, int quantity, String currency) {
        if(this.wallet.get(currency) != null) {
            this.wallet.put(currency, this.wallet.get(currency) - quantity);
        }
        else{
            this.wallet.put(currency,  quantity);
        }
    this.wallet.put("$", wallet.get("$") - (price * quantity));
    }
}
