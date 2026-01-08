import Controller.CuadradoMagico;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce el tamaño de la matriz (n): ");
        int n = teclado.nextInt();

        CuadradoMagico cubo = new CuadradoMagico(n);
        System.out.println("Buscando.....\n");
        long intentos = cubo.buscarCuadrado();
        cubo.mostrarCuadrado();

        System.out.println("Intentos realizados: "+intentos);
    }
}
