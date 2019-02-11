package com.indev.cryptocurrency.exchange;

public class Currency {
    private String  name ;
    private  int numb=0;

    public Currency(String name){
        this.name=name;
    }
    public Currency(String name, int numb){
        this.name=name;
        this.numb=numb;
    }

    public String getName() {
        return name;
    }

    public int getNumb() {
        return numb;
    }

    public void setNumb(int CurrencyNumb) {
        this.numb = CurrencyNumb;
    }
}
