package com.app.service;

import com.app.entity.Cart;
import com.app.entity.Product;

import java.util.HashMap;

public class CartServiceImpl implements CartService {
    private final Cart cart;
    private final ProductService productService;
    public CartServiceImpl() {
        this.cart = new Cart();
        this.cart.setProducts(new HashMap<>());
        this.productService = new ProductServiceImpl();
    }

    @Override
    public void add(Product product, int quantity) {
        HashMap<Product, Integer> products = cart.getProducts();
        try {
            if (product == null) {
                throw new IllegalArgumentException("Product cannot be null");
            }
            if (quantity <= 0) {
                throw new IllegalArgumentException("Quantity must be greater than zero");
            }
            if (!productService.isStockAvailable(product, quantity)) {
                throw new IllegalArgumentException("Insufficient stock for product: " + product.getName());
            }
            if(productService.isExpired(product)) {
                throw new IllegalArgumentException("Product is expired: " + product.getName());
            }
            products.put(product, products.getOrDefault(product, 0) + quantity);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void remove(Product product) {
        HashMap<Product, Integer> products = cart.getProducts();
        if (!cart.getProducts().isEmpty() && product != null) {
            products.remove(product);
        } else {
            System.err.println("Product cannot be null");
        }
    }

    @Override
    public void clearCart() {
        HashMap<Product, Integer> products = cart.getProducts();
        products.clear();
    }

    @Override
    public double calcSubtotal() {
        HashMap<Product, Integer> products = cart.getProducts();
        return products.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    @Override
    public boolean isCartEmpty() {
        return cart.getProducts().isEmpty();
    }

    @Override
    public HashMap<Product, Integer> getProducts() {
        return cart.getProducts();
    }
}
