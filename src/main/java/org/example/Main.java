package org.example;
import model.Product;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        instanciando();
        Main main = new Main();
        main.runMenu();
    }

    public static void instanciando(){
        Product productoAgua= new Product("agua", 2500, 1);
        System.out.println("Producto " + productoAgua.getName());
    }


    public void displayMenu() {

        System.out.println(
                """
                        |o|                         /////////////\\\\\\
                        |o|                        (((((((((((((   \\\\\\
                        |o|                        ))) ~~      ~~   (((
                        |o|                        ((( (*)     (*)  )))
                        |o|                        )))     <        (((\s
                        |o|                        ((( '\\______/`   )))\s
                        |o|                        )))\\___________/(((\s
                        |o|                        (((   _)  (_    )))\s\s
                        |o|                              /\\__/\\""");
        System.out.println("±----------------------------------------±");
        System.out.println("|   Administrador Mi Tienda de Barrio    |");
        System.out.println("±----------------------------------------±");
        System.out.println("1. Agregar producto                      |");
        System.out.println("2. Eliminar producto                     |");
        System.out.println("3. Actualizar producto                   |");
        System.out.println("4. Ver todos los productos               |");
        System.out.println("5. Ver el manual de usuario              |");
        System.out.println("6. Ver más opciones                                  |");
        System.out.println("7. Salir                                  |");
        System.out.println("±----------------------------------------±");
        System.out.print("   Ingresa tu opción:    (1 - 7)  ");
    }


    private void handleUserChoice(int choice){
        switch (choice) {
            case 1 -> addProduct();
            case 2 -> removeProduct();
            case 3 -> updateProduct();
            case 4 -> allProducts();
            case 5 -> userGuide();
            case 6 -> moreOptions();
            case 7 -> System.out.println("Saliendo...");
            default -> System.out.println("Opción inválida. Por favor intenta de nuevo.");
        }

    }

    public void addProduct(){
        System.out.println("a product will be added.");
    }
    public void removeProduct(){
        System.out.println("a product will be removed.");
    }
    public void updateProduct(){
        System.out.println("a product will be updated.");
    }
    public void allProducts(){
        System.out.println("All products.");
    }
    public void userGuide(){
        System.out.println("userGuide");
    }
    public void moreOptions(){
        System.out.println("a product will be removed.");
    }
    public void runMenu () {
        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            handleUserChoice(choice);
        } while (choice != 8);
    }
}
