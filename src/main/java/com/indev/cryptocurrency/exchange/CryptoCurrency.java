package com.indev.cryptocurrency.exchange;

public class CryptoCurrency {

    private String name;
    private int solde ;


    public CryptoCurrency(String name, int solde) {
        this.name = name;
        this.solde = solde;
    }

    @Override
    public String toString() {
        return solde+":"+name;
    }
    public boolean isNull(){
        if (name == null)
            return true;
        return false;
    }
    public void increaseSolde(int soldeAdd){
        solde +=soldeAdd;
    }
    public void decreaseSolde(int soldeSous){
        if (solde < soldeSous) return;
        solde -=soldeSous;
    }

    public String getName() {
        return name;
    }
}
