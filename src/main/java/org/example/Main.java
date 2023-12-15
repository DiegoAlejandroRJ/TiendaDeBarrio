package org.example;
import model.Product;
import model.User;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        instanciandoProducto();
        Main main = new Main();
        main.runMenu();
    }

    public static void instanciandoProducto(){
        Product productoAgua= new Product("agua", 2500, 1, "liquido");
        System.out.println("Producto " + productoAgua.getName());
        productoAgua.containsWord("agu");
        productoAgua.priceUpperComparison(80);
        productoAgua.priceLowerComparison(5000);
        productoAgua.aviableInStock();

        Product productoJugo = new Product("jugo", 3000, 3, "liquido");
        System.out.println("Producto " + productoJugo.getName());
        productoJugo.getStock();
    }

    public User instanciandoUser(){
        User mainUser =  new User();
        return mainUser;
    }

    public void handleUserChoice(int choice){
        User mainUser = instanciandoUser();
        switch (choice) {

            case 1 -> mainUser.addProduct();
            case 2 -> mainUser.removeProduct();
            case 3 -> mainUser.updateProduct();
            case 4 -> mainUser.allProducts();
            case 5 -> mainUser.userGuide();
            case 6 -> mainUser.moreOptions();
            case 7 -> System.out.println("Saliendo...");
            default -> System.out.println("Opción inválida. Por favor intenta de nuevo.");
        }

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
