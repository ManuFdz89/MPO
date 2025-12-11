import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner teclado = new Scanner(System.in);
    static ArrayList <Object[]> agenda = new ArrayList<>();
    //Object[] contacto = new Object[4];
    static String DNI ="";



    public static void main(String[] args) {

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
                case 1 -> agregarPersona();
                case 2 -> buscarPersona();
                case 3 -> borrarPersona();
                case 4 -> listarPersonas();
            }



        }while (opcion!=5);

        System.out.println("Cerrando la agenda.");

    }

    public static void agregarPersona(){
        Object[] contacto = new Object[4];

        System.out.print("Introduce el nombre: ");
        contacto[0] = teclado.next();
        System.out.print("Introduce el apellido: ");
        contacto[1] = teclado.next();
        System.out.print("Introduce el telefono: ");
        contacto[2] = teclado.nextInt();
        System.out.print("Introduce el DNI: ");
        contacto[3] = teclado.next();

        agenda.add(contacto);
        System.out.println("\nPersona agregada correctamente.");

    }

    public static void buscarPersona(){

        Object[] contacto;
        boolean encontrada = false;

        System.out.print("Introduce el DNI a buscar: ");
        DNI = teclado.next();

        for (int i = 0; i < agenda.size(); i++) {
            contacto = agenda.get(i);
            if (DNI.equalsIgnoreCase((String) contacto[3])){
                encontrada = true;
                System.out.println("Persona encontrada: ");
                System.out.printf("Nombre: %s\tApellido: %s\tTelefóno: %d%n",contacto[0],contacto[1],(int)contacto[2]);
            }
        }
        if (!encontrada) {
            System.out.println("Persona no encontrada");
        }

    }

    public static void borrarPersona(){

        Object[] contacto;
        boolean eliminada = false;

        System.out.print("Introduzca el DNI a borrar: ");
        DNI = teclado.next();

        for (int i = 0; i < agenda.size(); i++) {
            contacto = agenda.get(i);
            if (contacto[3].equals(DNI)){
                eliminada = true;
                agenda.remove(contacto);
                System.out.println("Persona eliminada correctamente");
                break;
            }
        }
        if (!eliminada){
            System.out.println("La persona no se ha eliminado");
        }

    }

    public static void listarPersonas(){

        Object[] contacto;

        if (agenda.size()==0){
            System.out.println("No hay personas en la agenda.");
        }else {
            for (int i = 0; i < agenda.size(); i++) {
                contacto = agenda.get(i);
                System.out.printf("Nombre: %s Apellido: %s Telefono: %d DNI: %s%n",contacto[0], contacto[1], (int) contacto[2], contacto[3]);
            }
        }
    }

}