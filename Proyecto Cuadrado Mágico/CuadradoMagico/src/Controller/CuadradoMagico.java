package Controller;

public class CuadradoMagico {

    private int[][] cuadrado;
    private int constante;
    private int tamanio;

    public CuadradoMagico() {
    }
    public CuadradoMagico(int tamanio) {
        this.tamanio = tamanio;
        this.cuadrado = new int[tamanio][tamanio];
        this.constante = (tamanio * ((tamanio * tamanio) + 1)) / 2;
    }
    public long buscarCuadrado(){
        long intentos = 0;
        do {
            intentos++;
            rellenarCuadrado();
        }while (!comprobarColumnas()||!comprobarFilas()||!comprobarDiagonales());
        return intentos;
    }
    public void mostrarCuadrado() {
        System.out.println("=== CUADRADO MÁGICO ENCONTRADO ===\n");
        for (int[] fila : cuadrado) {
            for (int columna : fila) {
                System.out.print("\t" + columna + "\t");
            }
            System.out.println("\n");
        }
        System.out.println("Constante Mágica: " + constante);

    }
    private void rellenarCuadrado() {
        int tamanioCuadrado = tamanio * tamanio;
        int[] temporales = new int[tamanioCuadrado];
        for (int i = 0; i < tamanioCuadrado; i++) {
            temporales[i] = i + 1;
        }
        for (int i = 0; i < tamanioCuadrado; i++) {
            int posicionAleatoria = (int) (Math.random() * tamanioCuadrado);
            int temp = temporales[i];
            temporales[i] = temporales[posicionAleatoria];
            temporales[posicionAleatoria] = temp;
        }
        int contador = 0;
        for (int i = 0; i < cuadrado.length; i++) {
            for (int j = 0; j < cuadrado[i].length; j++) {
                cuadrado[i][j] = temporales[contador];
                contador++;
            }
        }
    }
    private boolean comprobarColumnas(){

        for (int i = 0; i < cuadrado.length; i++) {
            int sumaColumna = 0;
            for (int j = 0; j < cuadrado[i].length; j++) {
                sumaColumna+=cuadrado[j][i];
            }
            if (sumaColumna!=constante){
                return false;
            }
        }
        return true;
    }
    private boolean comprobarDiagonales(){
        int sumaIzq = 0;
        int sumaDer = 0;

        for (int i = 0; i < cuadrado.length; i++) {
            sumaIzq += cuadrado[i][i];
            sumaDer += cuadrado[i][(tamanio - 1) - i];
        }
        if(sumaDer!=constante || sumaIzq!=constante){
            return false;
        }
        return true;
    }
    private boolean comprobarFilas(){

        for (int i = 0; i < cuadrado.length; i++) {
            int sumaFila = 0;
            for (int j = 0; j < cuadrado[i].length; j++) {
                sumaFila+=cuadrado[i][j];
            }
            if (sumaFila!=constante){
                return false;
            }
        }
        return true;
    }

    public int[][] getCuadrado() {
        return cuadrado;
    }
    public void setCuadrado(int[][] cuadrado) {
        this.cuadrado = cuadrado;
    }
    public int getConstante() {
        return constante;
    }
    public void setConstante(int constante) {
        this.constante = constante;
    }
    public int getTamanio() {
        return tamanio;
    }
    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    /* Primer intento para rellenar el cuadrado, para una matriz de 3x3 funciona bien, pero
    para una matriz superior tarda mucho en sacar los valores, tras analizarlo opto por implementar
    otro algoritmo.

    public void rellenarCuadrado() {
        int tamanioCuadrado = tamanio * tamanio;
        for (int i = 0; i < cuadrado.length; i++) {
            for (int j = 0; j < cuadrado[i].length; j++) {
                int temp = 0;
                do {
                    temp = (int) (Math.random() * tamanioCuadrado) + 1;
                } while (estaNumero(temp));
                cuadrado[i][j] = temp;
            }
        }
    }

    private boolean estaNumero(int numero) {
        for (int i = 0; i < cuadrado.length; i++) {
            for (int j = 0; j < cuadrado[i].length; j++) {
                if (cuadrado[i][j] == numero) {
                    return true;
                }
            }
        }
        return false;

    }*/
}









