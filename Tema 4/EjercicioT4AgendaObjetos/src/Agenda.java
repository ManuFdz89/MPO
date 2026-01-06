import java.util.ArrayList;

public class Agenda {

    private ArrayList<Contacto> listaContactos;
    public Agenda(){
        listaContactos = new ArrayList<>();
    }

    public void agregarContacto(Contacto nuevoContacto){
        listaContactos.add(nuevoContacto);
    }
    public void buscarPersonas(String DNI){
        if (listaContactos.isEmpty()){
            System.out.println("Lista vacia");
        }
        for (Contacto c: listaContactos){
            if (c.getDni().equalsIgnoreCase(DNI)){
                System.out.println("Contacto Encontrado");
                System.out.println("Nombre: "+c.getNombre());
                System.out.println("Apellido: "+c.getApellido());
                return;
            }
        }
        System.out.println("Contacto no encontrado");
    }
    public void borrarContacto(String DNI){
        if (listaContactos.isEmpty()){
            System.out.println("Lista vacia");
        }else {
            for (Contacto c : listaContactos) {
                if ((c.getDni().equalsIgnoreCase(DNI))) {
                    listaContactos.remove(c);
                    System.out.println("Borrado correctamente");
                    return;
                }
            }
        }
        System.out.println("Contacto no encontrado");
    }
    public void listarContactos(){
        for (Contacto c: listaContactos){
                System.out.println("Nombre: "+c.getNombre());
                System.out.println("Apellido: "+c.getApellido());
        }
    }



    public ArrayList<Contacto> getListaContactos(){
        return listaContactos;
    }
}
