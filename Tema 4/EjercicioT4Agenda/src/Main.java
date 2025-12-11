import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Scanner global para leer desde cualquier método.
    static Scanner teclado = new Scanner(System.in);

    // LA LISTA DINÁMICA (ArrayList):
    // <Object[]> significa que cada "hueco" de la lista guardará un Array de Objetos.
    // Es como una carpeta donde guardamos hojas (arrays) con datos.
    static ArrayList <Object[]> agenda = new ArrayList<>();

    // Variable auxiliar global para las búsquedas
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

            // Switch moderno (Java 14+) con flechas -> (más limpio).
            switch (opcion) {
                case 1 -> agregarPersona();
                case 2 -> buscarPersona();
                case 3 -> borrarPersona();
                case 4 -> listarPersonas();
            }

        } while (opcion!=5);

        System.out.println("Cerrando la agenda.");
    }

    // --- MÉTODO PARA CREAR (CREATE) ---
    public static void agregarPersona(){
        // IMPORTANTE: Aquí usamos 'new Object[4]'.
        // Cada vez que entramos aquí, Java crea un "papel en blanco" NUEVO en la memoria.
        // Si no hiciéramos 'new', estaríamos sobrescribiendo siempre los datos del anterior.
        Object[] contacto = new Object[4];

        System.out.print("Introduce el nombre: ");
        contacto[0] = teclado.next(); // Guardamos como String (posición 0)
        System.out.print("Introduce el apellido: ");
        contacto[1] = teclado.next(); // Guardamos como String (posición 1)
        System.out.print("Introduce el telefono: ");
        contacto[2] = teclado.nextInt(); // Guardamos como Integer (posición 2)
        System.out.print("Introduce el DNI: ");
        contacto[3] = teclado.next(); // Guardamos como String (posición 3)

        // Añadimos ese array específico a la lista
        agenda.add(contacto);
        System.out.println("\nPersona agregada correctamente.");
    }

    // --- MÉTODO PARA LEER/BUSCAR (READ) ---
    public static void buscarPersona(){

        // AQUÍ NO HACEMOS 'new'. Solo declaramos el puntero (la variable).
        // No necesitamos crear memoria nueva, solo queremos "apuntar" a lo que ya existe.
        Object[] contacto;
        boolean encontrada = false;

        System.out.print("Introduce el DNI a buscar: ");
        DNI = teclado.next();

        // Recorremos la lista
        for (int i = 0; i < agenda.size(); i++) {
            // Recuperamos el array guardado en la posición 'i'
            contacto = agenda.get(i);

            // CASTEO Y COMPARACIÓN:
            // 1. (String) contacto[3]: Como el array es de 'Object', hay que decirle a Java
            //    que lo trate como 'String' para poder usar sus métodos.
            // 2. .equalsIgnoreCase(): Compara texto ignorando mayúsculas/minúsculas.
            if (DNI.equalsIgnoreCase((String) contacto[3])){
                encontrada = true;
                System.out.println("Persona encontrada: ");

                // CASTEO EN EL PRINTF:
                // contacto[2] es un Object que contiene un int.
                // Debemos hacer (int) para que %d lo entienda.
                System.out.printf("Nombre: %s\tApellido: %s\tTelefóno: %d%n",
                        contacto[0], contacto[1], (int)contacto[2]);
            }
        }
        if (!encontrada) {
            System.out.println("Persona no encontrada");
        }
    }

    // --- MÉTODO PARA BORRAR (DELETE) ---
    public static void borrarPersona(){

        Object[] contacto; // Solo declaramos puntero (ahorro de memoria)
        boolean eliminada = false;

        System.out.print("Introduzca el DNI a borrar: ");
        DNI = teclado.next();

        for (int i = 0; i < agenda.size(); i++) {
            contacto = agenda.get(i);

            // Usamos .equals() para comparación exacta de Strings
            if (contacto[3].equals(DNI)){
                eliminada = true;

                // Removemos el objeto exacto que acabamos de encontrar
                agenda.remove(contacto);
                System.out.println("Persona eliminada correctamente");
                break; // Salimos del bucle porque ya lo borramos (eficiencia)
            }
        }
        if (!eliminada){
            System.out.println("La persona no se ha eliminado");
        }
    }

    // --- MÉTODO PARA LISTAR TODO (READ ALL) ---
    public static void listarPersonas(){

        Object[] contacto; // Puntero temporal

        // Comprobamos si la lista está vacía
        if (agenda.size()==0){
            System.out.println("No hay personas en la agenda.");
        }else {
            for (int i = 0; i < agenda.size(); i++) {
                contacto = agenda.get(i); // Apuntamos al contacto actual

                // Imprimimos casteando el teléfono a (int)
                System.out.printf("Nombre: %s Apellido: %s Telefono: %d DNI: %s%n",
                        contacto[0], contacto[1], (int) contacto[2], contacto[3]);
            }
        }
    }
}