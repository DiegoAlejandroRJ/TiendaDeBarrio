package org.example.controller;

import org.example.dto.ProductDto;
import org.example.exceptions.ProductNotFoundException;
import org.example.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.example.service.ProductsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/products")
public class ProductController {
    private final ProductsServiceImpl productsService;

    public ProductController(@Autowired ProductsServiceImpl productsService){
        this.productsService = productsService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createProduct = productsService.save(product);
        URI createdProductUri = URI.create("/v1/products/" + createProduct.getId());
        return ResponseEntity.created(createdProductUri).body(createProduct);
    }
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productsService.all();
        return ResponseEntity.ok(products);
    }
    @GetMapping("{id}")
    public ResponseEntity<Product> findById(@PathVariable String id) {
        Product product  = productsService.findById(id)
                .orElseThrow(()-> new ProductNotFoundException(id));
        return  ResponseEntity.ok(product);

    }
    @PutMapping ("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable ("id")String id, @RequestBody
    ProductDto productDto){
        try{
            Optional<Product> optionalProduct = productsService.findById(id);
            if(optionalProduct.isPresent()){
                Product existingProduct = optionalProduct.get();
                existingProduct.setName(productDto.getName());
                existingProduct.setPrice(productDto.getPrice());
                existingProduct.setStock(productDto.getStock());
                existingProduct.setCategory(productDto.getCategory());
                existingProduct.setDescription(productDto.getDescription());
                existingProduct.setTags(productDto.getTags());
                productsService.save(existingProduct);
                return ResponseEntity.ok(existingProduct);
            }else{
                throw new ProductNotFoundException(id);
            }
        } catch (ProductNotFoundException e) {
            throw e;
        }catch (Exception e){
            throw new ProductNotFoundException(id);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable ("id") String id ){
        Optional<Product> optionalProduct = productsService.findById(id);
        if (optionalProduct.isEmpty()){
            throw new ProductNotFoundException(id);

        }
        productsService.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }


}
