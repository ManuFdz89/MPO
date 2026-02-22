package Ejercicio1;

public class Main {

    public static void main(String[] args) {

        Libro libro1 = new Libro("El Quijote", "Miguel de Cervantes", 863, 25.50);
        Libro libro2 = new Libro("El Principito", "Antoine de Saint-Exupéry", 96, 15.00);
        Libro libro3 = new Libro("Clean Code", "Robert C. Martin", 464, 50.00);

        System.out.println("Libro creado: ");
        libro1.mostrarInfo();
        System.out.println("¿Es un libro largo? "+ libro1.esLibroLargo());

        System.out.println("Aplicando descuendo del 10%...");
        libro1.aplicarDescuento(10);
        System.out.println("Nuevo Precio: "+libro1.getPrecio());


    }
}
