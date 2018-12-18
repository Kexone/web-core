package com.web.example;

import java.util.List;

public interface ProductDao {
    Product getProduct(int id);
    List<Product> getProducts();
}
