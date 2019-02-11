package com.indev.cryptocurrency.exchange;

public class Customer implements AbstractCustomer {

    private Walette walette;
    private int balance;

    public Customer withCryptocurrency(String cryptocurrencyName, int cryptocurrencyBalance) {
        initWaletteWithCryptocurrency(cryptocurrencyName, cryptocurrencyBalance);
        return this;
    }

    private void initWaletteWithCryptocurrency(String cryptocurrencyName, int cryptocurrencyBalance) {
        walette = new Walette(cryptocurrencyName, cryptocurrencyBalance);
    }

    @Override
    public String toString() {
        return new DefaultCustomerBalancePresenter().getRepresentation(balance) +
                new DefaultWaletteBalanceRepresenter().getRepresentation(walette);
    }

    public Customer withBalance(int balance) {
        this.balance = balance;
        return this;
    }

    public boolean hasCryptocurrency(String cryptocurrencyName){
        return walette.hasCryptocurrency(cryptocurrencyName);
    }

    @Override
    public void doTransaction(TransactionRequest transactionRequest) {
        sell(transactionRequest.getCryptoPrice(), transactionRequest.getCryptoAmount());
        transactionRequest.getBuyer().buy(transactionRequest.getCryptoName()
                                        ,transactionRequest.getCryptoPrice()
                                        ,transactionRequest.getCryptoAmount());

    }

    private void buy(String boughtCryptoName, int cryptoPrice, int cryptoAmount){
        if(walette == null){
            walette = new Walette(boughtCryptoName);
        }
        walette.addCryptocurrencyBalance(cryptoAmount);
        reduceBalanceByAmount(cryptoPrice);
    }

    private void sell(int cryptoPrice, int cryptoAmount){
        addBalanceByAmount(cryptoPrice);
        walette.reduceCryptocurrencyBalance(cryptoAmount);
    }

    private void addBalanceByAmount(int amount){
        balance += amount;
    }

    private void reduceBalanceByAmount(int amount){
        balance -= amount;
    }
}
