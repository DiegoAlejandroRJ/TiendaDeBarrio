package controller;

import org.springframework.beans.factory.annotation.Autowired;
import service.ProductsServiceImpl;

public class ProductController {
    private final ProductsServiceImpl productsService;

    public ProductController(@Autowired ProductsServiceImpl productsService){
        this.productsService = productsService;
    }



}
