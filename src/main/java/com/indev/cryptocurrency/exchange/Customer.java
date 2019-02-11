package com.indev.cryptocurrency.exchange;

import java.util.*;

public class Customer {
    private  int nbrDollar=0;
    private Hashtable<String,Integer> currencies;
    public Customer withCryptocurrency(String bitcoin, int i) {

currencies.put(bitcoin,i);
        System.out.println(currencies.size());

        return this;
    }

    public Customer withBalance(int i) {
   this.nbrDollar=i;
   return this;
    }

    @Override
    public String toString() {
        String ret=this.nbrDollar+":$";
        System.out.println("this dol "+this.nbrDollar);
       Set<String> ta=currencies.keySet();
        Enumeration e=currencies.keys();
        String parama;
        while (e.hasMoreElements()){
      parama = (String)e.nextElement();
               ret+=","+currencies.get(parama)+":"+parama ;

      }
        System.out.println(ret);
      return ret;
    }

    public Customer() {
        this.currencies = new Hashtable<String,Integer> (); ;
    }

    public int getNbrDollar() {
        return nbrDollar;
    }

    public Hashtable<String, Integer> getCurrencies() {
        return currencies;
    }

    public void setNbrDollar(int nbrDollar) {
        this.nbrDollar = nbrDollar;
    }

    public void setCurrencieForSeller(String bit,int nv,int count) {
       int au=0;
        this.nbrDollar=this.nbrDollar*count*count;

        if(currencies.containsKey(bit))
        {

            au=currencies.get(bit)-nv;

           currencies.remove(bit);

             currencies.put(bit,au);

        }
    }

    public void setCurrencieForBuyer(String bit,int nv,int count) {


        if (count>1)
        this.withBalance(this.nbrDollar-nv*(count*count-count));
        else
            this.withBalance(this.nbrDollar-nv);
        System.out.println("ds "+this.nbrDollar);
        currencies.put(bit,nv);



    }
}
