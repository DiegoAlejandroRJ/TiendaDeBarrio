package org.example.service;

import org.example.model.Product;
import org.example.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements ProductsService{
    private final ProductsRepository productsRepository;

    @Autowired
    public ProductsServiceImpl (ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public Product save(Product product) {
        //String idProduct = product.getId();
        return (Product) productsRepository.save(product);
    }

    @Override
    public Optional<Product> findById(String id) {
        //User user = userMongoRepository.findById(id).get();
        return productsRepository.findById(id);
    }
    @Override
    public List<Product> all() {
        List<Product> productList = productsRepository.findAll();
        return productList;
    }
    @Override
    public void deleteById(String id) {
        Optional<Product> optionalProduct = productsRepository.findById(id);
        if (optionalProduct.isEmpty()){
        }
        productsRepository.deleteById(id);
    }
    @Override
    public Product update(Product product, String productId) {
        if (!product.getId().equals(productId)){
            throw new IllegalArgumentException("Product Id " + productId);
        }
        Product updateProduct = (Product) productsRepository.save(product);
        return (Product) productsRepository.save(product);
    }


}
