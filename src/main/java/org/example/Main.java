package org.example;
import model.ProductManager;
import java.util.Scanner;
import java.util.Calendar;

public class Main {

    ProductManager ProductManager = new ProductManager();
    public static void main(String[] args) {
        Calendar date = Calendar.getInstance();
        System.out.println("La fecha es: " + date.getTime());
        System.out.println("");
        System.out.println("");
        Main main = new Main();
        main.runMenu();
    }

    public void handleUserChoice(int choice){

        switch (choice) {
            case 1 -> ProductManager.addProduct();
            case 2 -> ProductManager.removeProduct();
            case 3 -> ProductManager.updateProduct();
            case 4 -> ProductManager.allProducts();
            case 5 -> ProductManager.userGuide();
            case 6 -> ProductManager.moreOptions();
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
