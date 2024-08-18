package com.electra.service;


import com.electra.model.Product;
import com.electra.repository.ProductRepository;

import java.util.List;

public class ProductService {
    private static final ProductRepository PRODUCT_REPO = new ProductRepository();

    // Method to retrieve products of the database
    public static List<Product> retrieveProducts() {
        return PRODUCT_REPO.retrieveProducts();

    }
}
