import java.util.ArrayList;

public class Agenda {

    private ArrayList<Object[]> listaContactos;
    public Agenda(){
        listaContactos = new ArrayList<>();
    }

    public void agregarContacto(Object[] contacto){
        listaContactos.add(contacto);
    }
    public void buscarPersonas(String DNI){
        if (listaContactos.isEmpty()){
            System.out.println("Lista vacia");
        }
        for (Object[] contacto: listaContactos){
            if (contacto[3].equals(DNI)){
                System.out.println("Contacto Encontrado");
                System.out.println("Nombre: "+contacto[0]);
                System.out.println("Apellido: "+contacto[1]);
                return;
            }
        }
        System.out.println("Contacto no encontrado");
    }
    public void borrarContacto(String DNI){
        if (listaContactos.isEmpty()){
            System.out.println("Lista vacia");
        }else {
            for (Object[] contacto : listaContactos) {
                if (contacto[3].equals(DNI)) {
                    listaContactos.remove(contacto);
                    System.out.println("Borrado correctamente");
                    return;
                }
            }
        }
        System.out.println("Contacto no encontrado");
    }
    public void listarContactos(){
        for (Object[] contacto: listaContactos){
                System.out.println("Nombre: "+contacto[0]);
                System.out.println("Apellido: "+contacto[1]);
        }
    }



    public ArrayList<Object[]> getListaContactos(){
        return listaContactos;
    }
}
