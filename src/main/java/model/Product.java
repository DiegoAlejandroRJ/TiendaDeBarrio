package model;

public class Product {
    private static String name;
    private static double price;
    private static int stock;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;

    }

    public static void containsWord(String palabraBuscada) {
        if(name.toLowerCase().contains(palabraBuscada.toLowerCase())){
            System.out.println("Se encontró el producto " + name +" con el criterio de búsqueda " + palabraBuscada);
        }
    }

    public static void priceUpperComparison(double inputNumber){
        if( price > inputNumber ){
            double diferencia =  (price - inputNumber);
            System.out.println("El precio del producto es mayor que el valor ingresado en " + diferencia);
        }
    }

    public static void aviableInStock(){
        if(stock <= 0){
            System.out.println("El producto no se encuentra en Stock.");
        } else {
            System.out.println("Hay " + stock + " item(s) en stock");
        }
    }


    public static void priceLowerComparison(double inputNumber){
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

    @Override
    public String toString() {
        return "{ 'name':" + name + ", price:" + price + ", stock:" + stock + "}";
    }

}



