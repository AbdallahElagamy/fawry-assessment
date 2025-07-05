package com.app.entity;

import java.util.HashMap;

public class Cart {
    private HashMap<Product, Integer> products;
    private final int shippingCost  = 10;

    public Cart() {
        this.products = new HashMap<>();
    }

    public HashMap<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(HashMap<Product, Integer> products) {
        this.products = products;
    }

    public int getShippingCost() {
        return shippingCost;
    }
}
