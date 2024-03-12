package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ProductManager implements Managing {

    private String id;

    public static void creatingProducts(){
        try {
            File file = new File("resources/inventory.csv");
            Scanner fileScanner = new Scanner(file);
            //Saltar el encabezado del CSV
            fileScanner.nextLine();
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] productInfo = line.split(",");

                Product product = new Product();
                int i = 0;
                while(i<line.length()){
                    product.setName(productInfo[0]);
                    product.setDescription(productInfo[1]);
                    product.setCategory(productInfo[2]);
                    product.setTags(productInfo[3]);
                    product.setPrice(Float.parseFloat(productInfo[4]));
                    //product.setImageUrl(productInfo[5]);
                    System.out.println(product);
                    i++;
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Product> productsArrayList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addProduct() {
        System.out.println("A product will be added. Please write the name of the product...");
        String newProductName = scanner.nextLine();
        System.out.println("Write the price of the product per unit...");
        int Price = scanner.nextInt();
        System.out.println("Type the units available in stock...");
        int Stock = scanner.nextInt();
        System.out.println("Write a description to the product...");
        scanner.nextLine();
        String Description = scanner.nextLine();
        System.out.println("Write the category of the product...");
        String Category = scanner.nextLine();
        System.out.println("Give a Tag to the product...");
        String Tag = scanner.nextLine();
        Product newProduct = new Product(id, newProductName, Price, Stock, Description, Category, Tag);
        System.out.println("Product " + newProduct.getName() + " Price: "+ Price + " Description: " + Description + " Category: " + Category + " Tag: " + Tag);
        productsArrayList.add(newProduct);
    }


    public void removeProduct() {
        System.out.println("A product will be removed. Please write the name of the product.");
        String ProductToRemove = scanner.nextLine();
        for (Product elem : productsArrayList) {
            if(Objects.equals(elem.name, ProductToRemove)) {
                productsArrayList.remove(elem);
                System.out.println("The product " + elem + " has been deleted.");
            } else {
                System.out.println("The product can not be found.");
            }
        }
    }

    public void updateProduct(){
        System.out.println("A product will be updated. Please write the name of the product you want to update.");
        String ProductToUpdate = scanner.nextLine();
        for (Product elem : productsArrayList) {
            if(Objects.equals(elem.name, ProductToUpdate)) {
                System.out.println("Product " + elem + " found");
                System.out.println("Please choose the attribute you want to update:");
                System.out.println("11. name                     |");
                System.out.println("12. price                    |");
                System.out.println("13. stock                    |");
                System.out.println("14. description              |");
                System.out.println("15. category                 |");
                System.out.println("16. tags                     |");
                int secondChoice = scanner.nextInt();
                switch (secondChoice) {
                    case 11 -> {
                        System.out.println("Please type the new name of the product.");
                        String NewProductName = scanner.nextLine();
                        elem.setName(NewProductName);
                    }
                     case 12 -> {
                         System.out.println("Please type the new price of the product.");
                         Double NewProductPrice = scanner.nextDouble();
                         elem.setPrice(NewProductPrice);
                    }
                    case 13 ->{
                        System.out.println("Please type the products in stock.");
                        int NewStock = scanner.nextInt();
                        elem.setStock(NewStock);
                    }

                    case 14 -> {
                        System.out.println("Please type the new descrption.");
                        String NewDescription = scanner.nextLine();
                        elem.setDescription(NewDescription);
                    }
                    case 15 -> {
                        System.out.println("Please type the new category.");
                        String NewCategory = scanner.nextLine();
                        elem.setDescription(NewCategory);
                    }
                    case 16 -> {
                        System.out.println("Please type the new tags.");
                        String NewTags = scanner.nextLine();
                        elem.setDescription(NewTags);

                    }
                }
            } else {
                System.out.println("The product can not be found.");
            }
        }

    }
    public void allProducts(){
        /*for (Product elem : productsArrayList){
            System.out.println(elem.toString());
        }*/
        System.out.println(productsArrayList.toString());
    }
    public void userGuide(){
        System.out.println("user guide");
    }
    public void moreOptions(){
        System.out.println("more options...");
    }
}
