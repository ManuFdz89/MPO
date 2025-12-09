import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

     static ArrayList<Object[]> agenda = new ArrayList<>();
     static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        aniadirPersona();



    }

    public static void aniadirPersona(){

        Object[] contacto = new Object[4];

        System.out.print("\nIntroduce el nombre: ");
        contacto[0] = teclado.next();
        System.out.print("Introduce el apellido: ");
        contacto[1] = teclado.next();
        System.out.print("Introduce el teléfono: ");
        contacto[2] = teclado.nextInt();
        System.out.print("Introduce el DNI: ");
        contacto[3] = teclado.next();

        agenda.add(contacto);

        for(Object[] item:agenda){
            System.out.printf("%s, %s; %d, %s",item[0],item[1],(int) item[2],item[3]);
        }



    }
}
