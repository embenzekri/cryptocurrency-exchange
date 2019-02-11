package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;
import java.util.List;

public class CryptocurrencyBank {

                private List<Customer> sellers;
                private int buyerRank;
                CryptocurrencyBank() {
                    this.sellers = new ArrayList<>();
                }



    void addSupportedCryptoCurrency(String bitcoin) {


    }

                    int requestTransaction(Customer buyerCustomer, int quantity, String cryptoName) {
                        try {
                            int priceInbalance;
                            Customer seller = searchSeller(cryptoName,quantity);
                            priceInbalance = quantity*calculatePrice();
                            updateSeller(seller,quantity,priceInbalance);
                            updateCustomer(buyerCustomer,quantity,cryptoName,priceInbalance);
                            return quantity;

                        }catch (Exception e){
                            return 0;
                        }

                    }
                    private int calculatePrice(){
                        buyerRank++;
                        if (buyerRank==1)
                            return 1;
                        return buyerRank*buyerRank-buyerRank;
                    }
                    private void updateSeller(Customer seller, int quantity, int priceInbalance){
                        seller.addDolars(priceInbalance);
                        seller.substructCrypto(quantity);
                    }
                    private void updateCustomer(Customer customer, int quantity, String cryptoName, int priceInbalance){
                        customer.addCrypto(quantity,cryptoName);
                        customer.substructDolars(priceInbalance);
                    }
                    private Customer searchSeller(String cryptoName,int quantity) throws Exception {
                        for (Customer sellerCustomer:sellers){
                            if (sellerCustomer.haveTheSameCryptocurrency(cryptoName)&&sellerCustomer.haveEnoughQuantity(quantity))
                                return sellerCustomer;
                        }
                        throw new Exception();
                    }



                        void addSeller(Customer sellerCustomer) {
                            sellers.add(sellerCustomer);
                        }
                    }

