package com.indev.cryptocurrency.exchange;

public enum Currency {

    Bitcoin(1, "Bitcoin"),
    Ethereum(2, "Ethereum");

    private int id;
    private String name;

    Currency(int id, String name) {
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
