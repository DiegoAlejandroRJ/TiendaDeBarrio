package model;

public class Product {
    private String name;
    private double price;
    private int stock;
    private String description;
    private String category;
    private String tags;

    public Product(String name, double price, int stock, String description) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.category = category;
        this.tags = tags;

    }

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
        return "{ 'name':" + name + ", price:" + price + ", stock:" + stock + "}";
    }

}



