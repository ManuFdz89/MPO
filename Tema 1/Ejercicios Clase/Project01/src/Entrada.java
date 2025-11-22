public class Entrada {

    public static void main(String[] args) {
        System.out.println("Ejecucion de metodos");
        System.out.println("Hola borja");
        saludar("borja");
        saludar("Manuel");

        Operaciones operacionesMatimaticas = new Operaciones();
        //primero el nombre de la clase, luego un nombre de variable "inventado"
        operacionesMatimaticas.sumar(2,4);
        //esta variable que hemos creado es como un intermnediario, sirve para dar seguridad al programa
        /* lo que hemos hecho es crear un objeto con la clase operaciones
        para poder usar los metodos que contiene
         */

        operacionesMatimaticas.sumar(8,4);

    }
    public static void saludar(String data){
        System.out.println("hola "+data);
        System.out.println("Este metodo se va a repetir en el saludo");
    }


}
