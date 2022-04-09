package com.honore.dev.REST.API.Controller;

import com.honore.dev.REST.API.Entity.Product;
import com.honore.dev.REST.API.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @GetMapping("/product/{name}")
    public Product findProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }

    @GetMapping("/products")
    public List<Product> findAllProduct() {
        return service.getProducts();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(int id) {
        return service.deleteProduct(id);
    }
}
