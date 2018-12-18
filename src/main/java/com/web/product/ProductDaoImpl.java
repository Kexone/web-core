package com.web.example;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("productDao")
public class ProductDaoImpl implements ProductDao {
    @Override
    public Product getProduct(int id) {
        if(id == 666) return null;

        return new Product("Honey", 0);
    }

    @Override
    public List<Product> getProducts() {
        List<Product> productsList = new ArrayList<>();
        productsList.add(new Product("Honey",0));
        productsList.add(new Product("Almond", 1));
        return productsList;
    }
}
