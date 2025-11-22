package model;

public class Operaciones {

    public void sumar(int op1, int op2){
        int resultado = op1+op2;
        System.out.println("El resultado de la suma es "+resultado);
    }

    public void restar(int op1, int op2){
        int resultado = op1-op2;
        System.out.println("El resultado de la resta es "+resultado);
    }

    public int multiplicacion(int op1, int op2){
        int resultado = op1*op2;
        System.out.println(resultado);
        // al final del metodo -> en la ultima linea tengo que decir que retorna
        return resultado;
    }

    public boolean validarNumero(int numero){
        return numero>10;
    }

}
