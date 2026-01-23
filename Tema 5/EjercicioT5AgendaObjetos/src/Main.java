import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Scanner global para leer desde cualquier método.
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        Agenda agenda = new Agenda();

        int opcion = 0;

        do {
            System.out.println("\n---  MENÚ AGENDA  ---");
            System.out.println("\n1. Agregar persona");
            System.out.println("2. Buscar persona");
            System.out.println("3. Borrar persona");
            System.out.println("4. Listar persona");
            System.out.println("5. Salir");

            System.out.print("\n Seleccione una opción: ");
            opcion = teclado.nextInt();
            System.out.println();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Introduce el nombre: ");
                    String nombre = teclado.next(); // Guardamos como String (posición 0)
                    System.out.print("Introduce el apellido: ");
                    String apellido = teclado.next(); // Guardamos como String (posición 1)
                    System.out.print("Introduce el telefono: ");
                    int telefono = teclado.nextInt(); // Guardamos como Integer (posición 2)
                    System.out.print("Introduce el DNI: ");
                    String DNI = teclado.next(); // Guardamos como String (posición 3)
                    Contacto nuevo = new Contacto(nombre,apellido,telefono,DNI);
                    agenda.agregarContacto(nuevo);
                }
                case 2 -> {
                    System.out.println("Dime el DNI a buscar: ");
                    String DNI = teclado.next();
                    agenda.buscarPersonas(DNI);
                }
                case 3 -> {
                    System.out.println("Dime el DNI a buscar: ");
                    String DNI = teclado.next();
                    agenda.borrarContacto(DNI);
                }
                case 4 -> agenda.listarContactos();
            }
        } while (opcion!=5);

        System.out.println("Cerrando la agenda.");

    }

}