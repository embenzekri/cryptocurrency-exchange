package com.indev.cryptocurrency.exchange;

import java.util.ArrayList;

import static java.lang.StrictMath.abs;

public class CryptocurrencyBank {
    ArrayList<Currency> Currencies;
    ArrayList<Customer> Sellers ;
    private int buyer=1;

    CryptocurrencyBank(){
        Currencies = new ArrayList<Currency>();
    }
    public void addSupportedCryptoCurrency(String name) {

        Currencies.add(new Currency(name));
    }

    public int requestTransaction(Customer buyerCustomer, int numb, String bitcoin) {
        int rest ;

        int result;
        if(Sellers==null){
            return 0;
        }else{

            result= numb - sell(buyerCustomer,numb,bitcoin);
            buyer = buyer+1;

            return result;
        }

    }

    public void addSeller(Customer sellerCustomer) {
       if(Sellers == null){
           Sellers = new ArrayList<Customer>();
       }
       Sellers.add(sellerCustomer);
    }

    public int sell(Customer buyerCustomer, int numb , String name){

        int result=0;
        int CurrencyNeed=numb;
        int DollarValue;
        if(buyer==1){
            DollarValue = 1 ;
        }else{
            DollarValue = (buyer*buyer) - buyer;
        }

        for(Customer seller : Sellers){
            if(seller.getCurrency().getName().equals(name)){
                int SellerCurrency = seller.getCurrency().getNumb();
                if(SellerCurrency >= CurrencyNeed){
                    result= SellerCurrency - CurrencyNeed;

                    buyerCustomer.setDollar(buyerCustomer.getDollar() - (CurrencyNeed * DollarValue));
                    buyerCustomer.setCurrency(new Currency("Bitcoin",CurrencyNeed));

                    seller.setCurrencyNumb(result);
                    seller.setDollar(seller.getDollar()+(CurrencyNeed * DollarValue));

                    CurrencyNeed = 0;

                }else{
                    CurrencyNeed= abs(SellerCurrency-CurrencyNeed);
                    seller.setCurrencyNumb(0);
                    seller.setDollar((SellerCurrency*DollarValue));
                }
            }

        }
        return CurrencyNeed;
    }
}
