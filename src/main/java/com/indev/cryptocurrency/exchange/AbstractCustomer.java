package com.indev.cryptocurrency.exchange;

public interface AbstractCustomer {
     boolean hasCryptocurrency(String cryptocurrencyName);
     void doTransaction(TransactionRequest transactionRequest);
}
