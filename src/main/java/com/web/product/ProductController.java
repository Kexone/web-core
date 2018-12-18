package com.web.example;


import com.web.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
//@RequestMapping(value = "/api")
@EnableAutoConfiguration
public class ProductController extends AbstractController {

    @Autowired
    ProductService productService;

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
        Product product = productService.getProduct(id);
        if(product == null)  throw new Exception("Error");
        return "Hello !" + product;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getProducts() {
        List<Product> productsList = productService.getProducts();
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


