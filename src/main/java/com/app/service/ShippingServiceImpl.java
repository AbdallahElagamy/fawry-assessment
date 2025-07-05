package com.app.service;

import com.app.entity.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShippingServiceImpl implements ShippingService {
    List<Product> shippedProducts;
    int count;

    public ShippingServiceImpl() {
        this.shippedProducts = new ArrayList<>();
    }

    @Override
    public void add(Product product) {
        shippedProducts.add(product);
    }

    @Override
    public List<Product> getAll() {
        return shippedProducts;
    }

    @Override
    public String getName(Product product) {
        return product.getName();
    }

    @Override
    public double getWeight(Product product) {
        return product.getShipmentInfo().getWeight();
    }

    @Override
    public double getDefaultShipmentCost() {
        return 10.0;
    }

    @Override
    public int countProducts(HashMap<Product, Integer> products, List<Product> shippedProducts) {
        for(Product product : shippedProducts) {
            count += products.get(product);
        }
        return count;
    }

}
