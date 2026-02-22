package Ejercicio2;

public class Estudiante {

    private String nombre;
    private int edad;
    private double notaMatematicas, notaProgramacion, notaIngles;

    public Estudiante(String nombre, int edad, double calcularPromedio, double notaProgramacion, double notaIngles) {
        this.nombre = nombre;
        this.edad = edad;
        this.notaMatematicas = calcularPromedio;
        this.notaProgramacion = notaProgramacion;
        this.notaIngles = notaIngles;
    }

    public double calcularPromedio(){

        return (notaMatematicas+notaIngles+notaProgramacion)/3;
    }
    public boolean estaAprobado(){

        return calcularPromedio()>=5;
    }
    public String obteberCalificacion(){

        switch ((int) calcularPromedio()){

            case 9, 10 -> {
                return "Sobresaliente";
            }
            case 7, 8 -> {
                return "Notable";
            }
            case 6 -> {
                return "Bien";
            }
            case 5 -> {
                return "Suficiente";
            }
            case 0, 1, 2, 3, 4 -> {
                return "Insuficiente";
            }
            default -> {
                return "Nota no valida";
            }
        }

    }
    public void mostrarInforme(){

        System.out.println("nombre = " + nombre);
        System.out.println("edad = " + edad);
        System.out.println("notaMatematicas = " + notaMatematicas);
        System.out.println("notaProgramacion = " + notaProgramacion);
        System.out.println("notaIngles = " + notaIngles);
        System.out.println("Promedio = " + calcularPromedio());
        System.out.println("Calificacion = " + obteberCalificacion());
        System.out.println("Aprobado? = " + estaAprobado());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getNotaMatematicas() {
        return notaMatematicas;
    }

    public void setNotaMatematicas(double notaMatematicas) {
        this.notaMatematicas = notaMatematicas;
    }

    public double getNotaProgramacion() {
        return notaProgramacion;
    }

    public void setNotaProgramacion(double notaProgramacion) {
        this.notaProgramacion = notaProgramacion;
    }

    public double getNotaIngles() {
        return notaIngles;
    }

    public void setNotaIngles(double notaIngles) {
        this.notaIngles = notaIngles;
    }
}
