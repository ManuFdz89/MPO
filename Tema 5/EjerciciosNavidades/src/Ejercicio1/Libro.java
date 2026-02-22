package Ejercicio1;

public class Libro {
    private String titulo, autor;
    private int numPaginas;
    private double precio;

    public Libro(String titulo, String autor, int numPaginas, double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
        this.precio = precio;
    }

    public void mostrarInfo(){
        System.out.println("titulo = " + titulo);
        System.out.println("autor = " + autor);
        System.out.println("numPaginas = " + numPaginas);
        System.out.println("precio = " + precio);
    }

    public boolean esLibroLargo(){
        return numPaginas>300;
    }
    public void aplicarDescuento(double porcentaje){
        this.precio -= (this.precio * porcentaje) / 100;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
