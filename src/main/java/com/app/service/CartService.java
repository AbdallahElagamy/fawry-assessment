package com.app.service;

import com.app.entity.Product;

import java.util.HashMap;

public interface CartService {
    void add(Product product, int quantity);
    void remove(Product product);
    void clearCart();
    double calcSubtotal();
    boolean isCartEmpty();
    HashMap<Product, Integer> getProducts();
}
