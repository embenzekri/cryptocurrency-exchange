package com.indev.cryptocurrency.exchange;

public enum CurrencyEnum {

    Bitcoin(1, "Bitcoin", 1),
    Ethereum(2, "Ethereum", 1);

    private int id;
    private String name;
    private int price;

    CurrencyEnum(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }
}
