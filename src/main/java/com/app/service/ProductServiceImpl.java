package com.app.service;

import com.app.entity.Product;
import com.app.entity.ProductDates;

public class ProductServiceImpl implements ProductService {
    @Override
    public boolean isStockAvailable(Product product, int quantity) {
        return product.getStockQuantity() >= quantity;
    }

    @Override
    public boolean isShippingAvailable(Product product) {
        return product.getShipmentInfo() != null;
    }

    @Override
    public boolean isExpired(Product product) {
        ProductDates productDates = product.getProductDates();
        return productDates != null && productDates.getExpiryDate() != null &&
               productDates.getExpiryDate().before(new java.util.Date());
    }
}
