public class Contacto {

    private String nombre, apellido, dni, email;
    private int telefono;

    public Contacto(String nombre, String apellido, int telefono, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getDni() {
        return dni;
    }
    public String getEmail() {
        return email;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public String toString(){

        return "Nombre: " + nombre + ", Apellido: " + apellido +
                ", Teléfono: " + telefono + ", Email: " + email;
    }



}
