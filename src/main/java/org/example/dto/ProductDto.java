package org.example.dto;

public class ProductDto {
    public String name;
    public double price;
    public int stock;
    public String description;
    public String category;
    public String tags;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public ProductDto() {
        this.name = "";
        this.price = 0;
        this.stock = 0;
        this.description ="";
        this.category = "";
        this.tags = "";
    } public ProductDto(String name, double price, int stock, String description, String category, String tags) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.category = category;
        this.tags = tags;
    }


}


