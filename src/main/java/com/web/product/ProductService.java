package com.web.example;

import java.util.List;

public interface ProductService {

    Product getProduct(int id);
    List<Product> getProducts();
}
