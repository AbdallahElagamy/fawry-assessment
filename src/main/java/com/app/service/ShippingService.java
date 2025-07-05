package com.app.service;

import com.app.entity.Product;

import java.util.HashMap;
import java.util.List;

public interface ShippingService {
    void add(Product product);
    List<Product> getAll();
    String getName(Product product);
    double getWeight(Product product);
    double getDefaultShipmentCost();
    int countProducts(HashMap<Product, Integer> products, List<Product> shippedProducts);
}
