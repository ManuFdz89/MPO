import model.Operaciones;

import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {
        System.out.println("Ejecucion de metodos");
        despedir();
        saludar("Borja");
        /*
        int numero1 = 4;
        int numero2=7;
        int suma = numero1+numero2;
        System.out.println(suma);

        numero1=20;
        numero2=10;
        suma = numero1+numero2;
        System.out.println(suma);*/
        int numero = 2;
        String nombre = "Borja";
        Operaciones operacionesMatematicas = new Operaciones();
        // operacionesMatematicas.sumar(4,76);
        // operacionesMatematicas.restar(5,8);
        // operacionesMatematicas.restar(5,1);
        // int resultado2 = operacionesMatematicas.multiplicacion(2,4) *2; // 30
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el numero que quieres validar");
        int numeroUsuario = scanner.nextInt();
        System.out.println("El numero es valido "+operacionesMatematicas.validarNumero(numeroUsuario));


    }

    public static void saludar(String data){
        System.out.println("Hola "+data);
        System.out.println("Buenos dias");
        System.out.println("Que tal estas");
        System.out.println("Quieres un cafe");
        System.out.println("Este metodo se va a repetir en el saludo");
    }

    public static void despedir(){
        System.out.println("Hasta luego");
        System.out.println("Por hoy ya hemos terminado");
        System.out.println("Vamos a cerrar la clase");
    }
}
