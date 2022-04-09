package com.honore.dev.REST.API.Services;

import com.honore.dev.REST.API.Entity.Product;
import com.honore.dev.REST.API.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product) {
        return (Product) repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProductById(int id) {
        return (Product) repository.findById(id).orElse(null);
    }

    public Product getProductByName(String name) {
        return repository.findByName(name);
    }

    public String deleteProduct(int id) {
        repository.deleteById(id);
        return String.format("The Product with the id < %d > has been removed", id);
    }

    public String deleteProducts(List<Product> products) {
        for (Product product : products) repository.deleteById(product.getId());
        return "The Products have been removed";
    }

    public Product updateProduct(Product product) {
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());

        return repository.save(existingProduct);
    }
}
