package com.indev.cryptocurrency.exchange;

public enum Currency {

    Bitcoin(1, "Bitcoin", 1),
    Ethereum(2, "Ethereum", 1);

    private int id;
    private String name;
    private int price;

    Currency(int id, String name, int price) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
