package com.web.controllers;


import com.web.services.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
//@RequestMapping(value = "/api")
@EnableAutoConfiguration
public class ExampleController extends AbstractController{

    @Autowired
    ExampleService exampleService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String home() {
        return "Hello World!";
    }

    @RequestMapping(value = "/next", method = RequestMethod.GET)
    String next() {
        return "Hello Next!";
    }

    @RequestMapping(value = "/some/{id}", method = RequestMethod.GET)
    String some(@PathVariable("id") int id) throws Exception {
        if(id == 666)  throw new Exception("Error");
        return "Hello !" + id;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<String> getProducts() {
        List<String> productsList = exampleService.getProducts();
        return productsList;
    }
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public String createProduct() {
        return "Product is saved successfully";
    }

    @RequestMapping("/locale")
    public String locale() {
        return "locale";
    }
}


