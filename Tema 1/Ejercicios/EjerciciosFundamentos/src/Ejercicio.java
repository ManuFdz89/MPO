import javax.swing.*;
import java.util.Scanner;

public class Ejercicio {

    private Scanner teclado;
    /*
    Hágase una aplicación que permita introducir el número de bebidas y bocadillos
    comprados (valores entre 0 y 20). Además se podrá introducir el precio de cada
    bebida (valor entre 0.00 € y 3.00 €) y de cada bocadillo (valor entre 0.00 € y 5.00
    €). También se podrá introducir el número de alumnos que realizaron la compra
    (valor entre 0 y 10). Se mostrará el total de la compra (con el subtotal de las
    bebidas y de los bocadillos) y la cantidad que debe pagar cada alumno
    redondeada a 2 decimales.
     */
    public void ejercicio1() {
        /*  1 -> Pedir cosas por teclado
            2 -> guardar cosas en variables
            3 -> realizar calculos
            4 -> mostrar informacion */

        teclado = new Scanner(System.in);
        System.out.println("Cuantas bebidas vas a comprar");
        int bebidas = teclado.nextInt();
        System.out.println("Cuantoss bocadillos vas a comprar");
        int bocadillos = teclado.nextInt();
        System.out.println("Cuanto vale cada bebida");
        double precioBebidas = teclado.nextDouble();
        System.out.println("Cuanto vale cada bocadillo");
        double precioBocadillo = teclado.nextDouble();
        System.out.println("Cuantos alumnos realizaron la compra");
        int alumnos = teclado.nextInt();

        double costeBebidas = bebidas * precioBebidas;
        double costeBocadillo = bocadillos * precioBocadillo;
        double compra = costeBebidas + costeBocadillo;
        double precioPersona = compra/alumnos;

        System.out.printf("Subtotal bebidas: %.2f %n",costeBebidas);
        System.out.printf("Subtotal bocadillos: %.2f %n",costeBocadillo);
        System.out.printf("total compra: %.2f%n",compra);
        System.out.printf("Cantidad por alumnos: %.2f %n",precioPersona);

        teclado.close();
    }

    public void ejercicio2(){

        teclado = new Scanner(System.in);
        //Pedir datos
        System.out.print("Introduzca el valor de la compra: ");
        double vCompra = teclado.nextDouble();
        System.out.print("Introduzca el valor del IVA: ");
        int vIva = teclado.nextInt();
        //Calculos
        double pSinIva = vCompra / ((100.0+vIva)/100.0);
        double costeIva = vCompra - pSinIva;
        //mostramos resultado en pantalla
        System.out.printf("Valor de la compra: %.2f%n",pSinIva);
        System.out.printf("IVA: %.2f%n",costeIva);

        teclado.close();
    }

    public void ejercicio3(){

        teclado = new Scanner(System.in);

        /*
        Se introducen los 5 dígitos de un número (decenas de mil, unidades de mil, centenas, decenas y unidades), y se obtiene el número correspondiente. (Numero)
        Decenas de mil: 7
        Unidades de mil: 9
        Centenas: 0
        Decenas: 5
        Unidades: 0
        Numero introducido: 79050
         */
        System.out.println("Introduce un número descompuesto de la siguiente forma:");
        System.out.print("Decenas de mil: ");
        int decenasMil = teclado.nextInt();
        System.out.print("Unidades de mil: ");
        int unidadesMil = teclado.nextInt();
        System.out.print("Centenas: ");
        int centenas = teclado.nextInt();
        System.out.print("Decenas: ");
        int decenas = teclado.nextInt();
        System.out.print("Unidades: ");
        int unidades = teclado.nextInt();

        decenasMil = decenasMil * 10000;
        unidadesMil = unidadesMil * 1000;
        centenas = centenas * 100;
        decenas =decenas * 10;

        int numero = decenasMil+unidadesMil+centenas+decenas+unidades;

        System.out.println("El número introducido es: "+numero);

        unidades = numero %10;
        decenas = (numero/10)%10;
        centenas = (numero/100)%10;
        unidadesMil = (numero/1000)%10;
        decenasMil = (numero/10000)%10;

        System.out.printf("las decenas de mil son %d, las unidades de mil son %d, las centenas son %d, las decenas son %d,y las unidades son %d",
                decenasMil, unidadesMil, centenas, decenas,unidades);



    }

    public void ejercicio4(){

        /*
        Hágase un programa que convierta segundos en horas, minutos y segundos.(Segundos)
        Número de segundos: 24973 Horas: 6 Minutos: 56 Segundos: 13
         */

        teclado = new Scanner(System.in);

        System.out.print("Introduce número de segundos: ");
        int numero = teclado.nextInt();

        int horas = numero/3600;
        int minutos = (numero%3600)/60;
        int segundos = (numero%3600)%60;

        System.out.printf("Horas %d%nMinutos %d%nSegundos %d%n", horas, minutos, segundos);





    }



}
