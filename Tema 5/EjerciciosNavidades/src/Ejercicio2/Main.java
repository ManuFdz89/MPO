package Ejercicio2;

public class Main {

    public static void main(String[] args) {
        // CASO 1: El Cerebrito (Sobresaliente) 🤓
        // Promedio esperado: ~9.6
        Estudiante e1 = new Estudiante("Ana García", 20, 9.5, 10.0, 9.5);
        e1.mostrarInforme();
        System.out.println("-------------------------------------------------");

        // CASO 2: El que va sobrado (Notable) 😎
        // Promedio esperado: 8.0
        Estudiante e2 = new Estudiante("Carlos Ruiz", 22, 7.5, 8.5, 8.0);
        e2.mostrarInforme();
        System.out.println("-------------------------------------------------");

        // CASO 3: El que vive al límite (Suficiente) 😅
        // Promedio esperado: 5.0 exacto (Prueba de borde)
        Estudiante e3 = new Estudiante("Luis Pérez", 19, 5.0, 4.0, 6.0);
        e3.mostrarInforme();
        System.out.println("-------------------------------------------------");

        // CASO 4: El que necesita estudiar más (Insuficiente) 😢
        // Promedio esperado: ~3.3
        Estudiante e4 = new Estudiante("Sofía López", 21, 2.0, 4.0, 4.0);
        e4.mostrarInforme();
        System.out.println("-------------------------------------------------");

        // --- PRUEBA EXTRA: RECUPERACIÓN ---
        System.out.println("\n--- PRUEBA DE RECUPERACIÓN DE SOFÍA ---");
        System.out.println("Sofía estudia mucho y repite el examen de mates...");

        // Cambiamos una nota usando el SETTER
        e4.setNotaMatematicas(9.0);

        System.out.println("Nuevas notas de Sofía:");
        // Volvemos a mostrar para ver si el promedio y la calificación se actualizan solos
        e4.mostrarInforme();
    }
}
