package com.app;

import com.app.entity.Customer;
import com.app.entity.Product;
import com.app.entity.ShipmentInfo;
import com.app.entity.ProductDates;
import com.app.service.*;

import java.util.HashMap;
import java.util.List;

public class Runner {
    private static ShippingService shippingService;

    public static void main(String[] args) {
        Product cheese = new Product(1, "Cheese", 100, 50,
                new ShipmentInfo(2.5, "Air"),
                new ProductDates(new java.util.Date(), new java.util.Date(System.currentTimeMillis() + 86400000)));
        Product tv = new Product(2, "TV", 500, 20,
                new ShipmentInfo(15.0, "Sea"),
                null);
        Product scratchCard = new Product(3, "Scratch Card", 10, 1000,
                null,
                new ProductDates(new java.util.Date(), new java.util.Date(System.currentTimeMillis() + 259200000)));
        List<Product> products = List.of(cheese, tv, scratchCard);

        Customer customer = new Customer(1, "John Doe", "johndoe@gmail.com", "1234567890",
                10000, "123 Main St, Springfield, USA");



        CartService cart = new CartServiceImpl();
        cart.add(cheese, 2);
        cart.add(tv, 3);
        cart.add(scratchCard, 1);

        HashMap<Product, Integer> cartProducts = cart.getProducts();
        shippingService = new ShippingServiceImpl();
        ProductService productService = new ProductServiceImpl();
        for (Product product : cartProducts.keySet()) {
            if (productService.isShippingAvailable(product) && !productService.isExpired(product)
                    && productService.isStockAvailable(product, 1)) {
                shippingService.add(product);
            }
        }

        checkout(customer, cart);
    }

    private static void checkout(Customer customer, CartService cart) {
        if (cart.isCartEmpty()) {
            System.err.println("Your cart is empty. Please add products to your cart before checking out.");
        } else {
            List<Product> shippedProducts = shippingService.getAll();
            HashMap<Product, Integer> cartProducts = cart.getProducts();
            double subtotal = cart.calcSubtotal();
            double shipmentCost = shippingService.getDefaultShipmentCost() * shippingService.countProducts(cartProducts, shippedProducts);
            double totalPrice = subtotal + shipmentCost;
            double totalWeight = 0;

            if (totalPrice > customer.getBalance()) {
                System.err.println("Insufficient balance. Please add funds to your account.");
                return;
            }
            System.out.println("** Shipment notice **");

            for (Product product : shippedProducts) {
                System.out.printf("%dx %-15s %10.2fg\n",
                        cartProducts.get(product),
                        shippingService.getName(product),
                        shippingService.getWeight(product) * cartProducts.get(product));
                totalWeight += shippingService.getWeight(product) * cartProducts.get(product);
            }
            System.out.printf("Total package weight %10.2fg\n\n", totalWeight);

            System.out.println("** Checkout receipt **");
            for (Product product : cart.getProducts().keySet()) {
                System.out.printf("%dx %-15s %10.2f\n",
                        cart.getProducts().get(product),
                        product.getName(),
                        product.getPrice() * cart.getProducts().get(product));
            }

            System.out.println("--------------------------------------------------");

            System.out.printf("%-15s %10.2f\n", "Subtotal", subtotal);
            System.out.printf("%-15s %10.2f\n", "Shipping cost", shipmentCost);
            System.out.printf("%-15s %10.2f\n", "Total price", totalPrice);
            System.out.printf("Customer balance after checkout %10.2f\n",
                    customer.getBalance() - totalPrice);
        }
    }
}