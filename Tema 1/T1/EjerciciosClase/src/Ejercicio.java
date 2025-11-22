import java.util.Scanner;

public class Ejercicio {
    private Scanner lectorTeclado; // null
    /*
    Hágase una aplicación que permita introducir el número de bebidas y bocadillos
    comprados (valores entre 0 y 20). Además se podrá introducir el precio de cada
    bebida (valor entre 0.00 € y 3.00 €) y de cada bocadillo (valor entre 0.00 € y 5.00
    €). También se podrá introducir el número de alumnos que realizaron la compra
    (valor entre 0 y 10). Se mostrará el total de la compra (con el subtotal de las
    bebidas y de los bocadillos) y la cantidad que debe pagar cada alumno
    redondeada a 2 decimales.
     */
    public void ejercicio1(){
        lectorTeclado = new Scanner(System.in);
        // 1 -> pedir cosas por teclado
        // 2 -> guardar cosas en variables
        System.out.println("Cuantas bebidas vas a comprar");
        int bebidas = lectorTeclado.nextInt();
        System.out.println("Cuantos bocadillos vas a comprar");
        int bocatas = lectorTeclado.nextInt();
        System.out.println("Cuanto vale cada bebida");
        double precioBebida = lectorTeclado.nextDouble();
        System.out.println("Cuanto vale cada bocata");
        double precioBocata = lectorTeclado.nextDouble(); // 3,20
        System.out.println("Cuantas personas han realizado la comra");
        int numeroPersonas = lectorTeclado.nextInt();
        // 3 -> realizar calculos
        double costeBocadillos = bocatas*precioBocata;
        double costeBebidas = bebidas*precioBebida;
        double costeTotal = costeBebidas+costeBocadillos;
        double precioPersona = costeTotal/numeroPersonas;
        // 4 -> mostrar informacion
        System.out.printf("El precio total de la compra es %.2f%n",costeTotal);
        System.out.printf("El precio total de los bocatas es %.2f%n",costeBocadillos);
        System.out.printf("El precio total de las bebidas es %.2f%n",costeBebidas);
        System.out.printf("El precio a pagar por persona es %.2f%n",precioPersona);
        lectorTeclado.close();
    }

    public void ejercicio4(){
        /*
        Hágase un programa que convierta segundos en horas, minutos y segundos.
         */
        // 1-> pedir datos
        lectorTeclado = new Scanner(System.in);
        System.out.println("Cuantos seg quieres pasar a tiempo");
        int segundos = lectorTeclado.nextInt();
        // 2-> realizar calculos
            // segundos en horas-> 3600
            // minutos en horas -> 60
            // segundos en minutos -> 60
        int horas = segundos/3600;
        int minutos = (segundos%3600)/60;
        int segudos = segundos%60;
        // 3-> mostrar datos
        System.out.println("El numero de horas es "+horas);
        System.out.println("El numero de minutos es "+minutos);
        System.out.println("El numero de segundos es "+segudos);
        lectorTeclado.close();
    }
}
