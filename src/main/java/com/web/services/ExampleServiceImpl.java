package com.web.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExampleServiceImpl implements ExampleService {

    @Override
    public String getProductName() {
        return "Honey";
    }

    @Override
    public List<String> getProducts() {
        List<String> productsList = new ArrayList<>();
        productsList.add("Honey");
        productsList.add("Almond");
        return productsList;
    }
}
