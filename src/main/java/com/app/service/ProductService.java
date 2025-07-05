package com.app.service;

import com.app.entity.Product;

public interface ProductService {
    boolean isStockAvailable(Product product, int quantity);
    boolean isShippingAvailable(Product product);
    boolean isExpired(Product product);
}
