package org.example;

import org.example.model.ProductManager;

import java.util.Calendar;
import java.util.Scanner;

public class Menu {

    public void handleUserChoice(int choice){
        ProductManager productManager = new ProductManager();
        switch (choice) {
            case 1 -> productManager.addProduct();
            case 2 -> productManager.removeProduct();
            case 3 -> productManager.updateProduct();
            case 4 -> productManager.allProducts();
            case 5 -> productManager.userGuide();
            case 6 -> productManager.moreOptions();
            case 7 -> System.out.println("Saliendo...");
            default -> System.out.println("Opción inválida. Por favor intenta de nuevo.");
        }
    }

    public void displayMenu() {
        Calendar date = Calendar.getInstance();
        System.out.println("La fecha es: " + date.getTime());
        System.out.println("");
        System.out.println("");
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
        System.out.println("6. Ver más opciones                      |");
        System.out.println("7. Salir                                 |");
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
