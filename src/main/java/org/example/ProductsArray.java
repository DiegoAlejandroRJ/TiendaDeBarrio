package org.example;
import java.util.Scanner;
import java.util.Arrays;
public class ProductsArray {
    public static void main(String[] args) {
        String[] productsArray = new String[20];
        productsArray[0]= "agua";
        productsArray[1]= "leche";
        productsArray[2]= "café";
        productsArray[3]= "huevos";
        productsArray[4]= "pan";
        productsArray[5]= "chocolate";
        productsArray[6]= "fresas";
        productsArray[7]= "té";
        productsArray[8]= "helado";
        productsArray[9]= "postre";
        productsArray[10]= "juho";
        productsArray[11]= "pastel";
        productsArray[12]= "galletas";
        productsArray[13]= "aromática";
        productsArray[14]= "papas";
        productsArray[15]= "queso";
        productsArray[16]= "yogurt";
        productsArray[17]= "servilletas";
        productsArray[18]= "huevos cocinados";
        productsArray[19]= "alfajor";


        System.out.println(" ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa la letra inicial de un producto y el sistema arrojará la lista de los productos que inician con esa letra");
        System.out.println(" ");
        String letter = scanner.nextLine();
        scanner.close();
        System.out.println("Productos que inician con la letra (" + letter +"):");
        printer(productsArray, letter);
        alphabeticOrder(productsArray);

    }
    public static void printer(String[] productsArray, String letra) {
        for (String product : productsArray){
            if(product.startsWith(letra)){
                System.out.println(product);
            }
        }
    }

    public static void alphabeticOrder (String[] productsArray){
        Arrays.sort(productsArray);
        System.out.println("A continuación se presentan los productos ordenados alfabéticamente: ");
        for (String product : productsArray){
            System.out.println(product + " ");
        }
    }
}



