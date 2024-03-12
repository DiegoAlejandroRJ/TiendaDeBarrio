package service;

import model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductsService {
    Object save(Product product);

    Optional<Product> findById(String id);

    List<Product> all();

    void deleteById(String id);

    Product update(Product product, String productId);

    Product update(Product product, int productId);
}
