package com.indev.cryptocurrency.exchange;

public class DefaultCustomerBalancePresenter implements BalanceRepresenter {

    @Override
    public String getRepresentation(int balance) {
        return balance+":$";
    }
}
