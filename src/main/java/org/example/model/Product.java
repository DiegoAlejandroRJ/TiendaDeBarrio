package model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "product_collection")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    public String name;
    public double price;
    public int stock;
    public String description;
    public String category;
    public String tags;

    public Product(String id, String name, double price, int stock, String description, String category, String tags) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.category = category;
        this.tags = tags;

    }

    public Product() {

    }
    /*
    public void containsWord(String palabraBuscada) {
        if(name.toLowerCase().contains(palabraBuscada.toLowerCase())){
            System.out.println("Se encontró el producto " + name +" con el criterio de búsqueda " + palabraBuscada);
        }
    }

    public void priceUpperComparison(double inputNumber){
        if( price > inputNumber ){
            double diferencia =  (price - inputNumber);
            System.out.println("El precio del producto es mayor que el valor ingresado en " + diferencia);
        }
    }

    public void aviableInStock(){
        if(stock <= 0){
            System.out.println("El producto no se encuentra en Stock.");
        } else {
            System.out.println("Hay " + stock + " item(s) en stock");
        }
    }

    public void priceLowerComparison(double inputNumber){
        if( price <= inputNumber ){
            double diferencia =  (inputNumber - price);
            System.out.println("El precio del producto es menor que el valor ingresado en " + diferencia);
        }
    }*/

    public String getId() {
        return id;
    }
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

    @Override
    public String toString() {
        return "{ 'name':" + name + ", price:" + price + ", stock:" + stock + ", description:"+description+", category:"+category+",tags: "+tags+ "}";
    }



}



