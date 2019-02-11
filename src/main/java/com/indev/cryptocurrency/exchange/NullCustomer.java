package com.indev.cryptocurrency.exchange;

public class NullCustomer implements AbstractCustomer{

    @Override
    public boolean hasCryptocurrency(String cryptocurrencyName) {
        return false;
    }

    @Override
    public void doTransaction(TransactionRequest transactionRequest) {
        throw new UnsupportedOperationException("No seller found");
    }
}
