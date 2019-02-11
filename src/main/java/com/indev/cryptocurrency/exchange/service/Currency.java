package com.indev.cryptocurrency.exchange.service;

public class Currency {

    private int id;
    private String name;
    private int price;

    public Currency() {
    }

    public Currency(String name) {
        this.name = name;
    }

    public Currency(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
