package Metodos;

import javax.swing.*;
import java.util.Scanner;

public class Modulares {
    Scanner teclado = new Scanner(System.in);

    boolean validarContrasenia(String password){

        boolean longitud = password.length()<8;
        boolean mayuscula = false;
        boolean contNumero = false;

        for (int i = 0; i < password.length();i++){
            char letra = password.charAt(i);
            if(letra>='0' && letra<='9'){
                contNumero = true;
            }
            if(letra>='A' && letra<='Z') {
                mayuscula = true;
            }
        }
        if (longitud || !contNumero || !mayuscula){
            return false;
        }else {
            return true;
        }
    }
    public void ejercicio1(){

        System.out.println("Introduce una contraseña: ");
        String contrasenia="";

        while (!validarContrasenia(contrasenia)){
            contrasenia = teclado.next();
            if (!validarContrasenia(contrasenia)) {
                System.out.println("Contraseña no valida, introduce una contraseña correcta");
            }else {
                System.out.println("Contraseña correcta");
            }
        }
    }

    int buscarNumero(int[] numeros, int objetivo){

        // 1. Inicialización en "Estado de Fallo"
        // Empezamos asumiendo que NO lo vamos a encontrar (-1).
        // Si el array estuviera vacío o no estuviera el número, devolveríamos esto.
        int tmp = -1;

        // 2. Recorrido del Array
        for (int i = 0; i < numeros.length; i++){

            // 3. Comprobación
            if (numeros[i] == objetivo){
                tmp = i; // Guardamos la posición donde lo hemos visto

                // 4. EL BREAK (Optimización)
                // Como ya lo hemos encontrado, no tiene sentido seguir mirando el resto.
                // 'break' rompe el for inmediatamente y salta a la línea después del bucle.
                break;
            }
        }
        // 5. Devolvemos el resultado (será la posición o -1 si no entró en el if)
        return tmp;
    }
    public void ejercicio2(){

        int[] numerosP = new int[]{4,8,6,2};
        System.out.println("Introduce el valor a buscar: ");
        int objetivoP = teclado.nextInt();

        // Llamamos al método. Si devuelve algo menor que 0 (-1), es que falló.
        if (buscarNumero(numerosP, objetivoP) < 0){
            System.out.println("El numero buscado no se encuentra en la lista");
        } else {
            // Si lo encontró, volvemos a llamar al método para imprimir el valor.
            // (Nota: Podríamos guardar el resultado en una variable para no llamar dos veces, pero así funciona bien).
            System.out.println("La posicion del numero buscado es: " + buscarNumero(numerosP, objetivoP));
        }
    }

    void mostrarPares(int[] numeros){

        // Recorremos el array desde la posición 0 hasta la última
        for (int i=0; i< numeros.length; i++){

            // Comprobamos si el número es PAR (el resto de dividir entre 2 es 0)
            if (numeros[i]%2==0){
                System.out.println("El numero recorrido es par "+numeros[i]);
            }else {
                // SI ES IMPAR:
                // 'continue' salta inmediatamente a la siguiente vuelta del bucle (i++)
                // ignorando cualquier código que hubiera debajo.
                continue;
            }
        }
    }
    public void ejercicio3(){
        // 1. Creamos un array con capacidad para 20 números
        int[] numerosP = new int[20];

        // 2. Lo rellenamos con datos
        for (int i = 0; i < numerosP.length; i++){
            // Genera un número aleatorio entre 0 y 19
            numerosP[i] = (int) (Math.random()*20);
            // Imprimimos para verificar qué números se han generado
            System.out.println(numerosP[i]);
        }

        // 3. Llamamos al método que hace el trabajo de filtrar
        mostrarPares(numerosP);
    }

    double calcularPromedio(double[] notas){

        double suma = 0;      // Acumulador para las notas válidas
        double promedio = 0;  // Variable para el resultado final
        int contador = 0;     // Contador para saber por cuánto dividir al final

        for(int i = 0; i < notas.length ; i++){

            // FILTRO DE VALIDACIÓN:
            // Si la nota es menor que 0 (negativa) O mayor que 10...
            if (notas[i]<0 || notas[i]>10){
                // ...es inválida. Usamos continue para saltarla y no sumarla.
                continue;
            }else {
                // Si llegamos aquí, la nota es válida (0-10).
                suma += notas[i]; // La sumamos al total
                contador++;       // Contamos una nota válida más
            }

        }
        // Calculamos la media real solo con las notas válidas
        promedio = suma/contador;

        return promedio; // Devolvemos el dato
    }
    public void ejercicio4(){

        // Creamos array de 10 huecos
        double[] nota = new double[10];

        for (int i = 0; i < nota.length; i++) {
            // TRUCO MATEMÁTICO:
            // (Math.random() * 20) genera de 0 a 19.99
            // Al restar 5, el rango pasa a ser de -5 a 14.99.
            // Esto fuerza a que aparezcan notas negativas y mayores a 10 para probar el filtro.
            nota[i] = (Math.random()*20) -5;

            System.out.println("las notas introducidas son "+nota[i]);
        }

        // Llamamos al método e imprimimos el resultado directamente
        System.out.println("el promedio es "+calcularPromedio(nota));

    }

    boolean intentarLogin(String inputUser, String inputPass){

        // Datos "Hardcodeados" (Correctos)
        String usuarioReal = "Manu";
        String passReal = "Password.";

        // Comprobación: equalsIgnoreCase para el nombre, equals para la pass
        if (usuarioReal.equalsIgnoreCase(inputUser) && passReal.equals(inputPass)) {
            return true;
        }
        return false;
    }
    public void ejercicio5(){

        // Inicializamos vacíos fuera del bucle para usarlos después
        String usuarioP ="";
        String contraseniaP = "";

        // BUCLE DE 3 INTENTOS
        for (int i = 0; i < 3; i++){

            System.out.println("--- Intento " + (i+1) + " ---"); // (i+1) para que diga 1, 2, 3

            System.out.println("Introduce el usuario: ");
            usuarioP = teclado.next();

            System.out.println("Introduce la contraseña: ");
            contraseniaP = teclado.next();

            // Si acierta, marcamos éxito y salimos
            if (intentarLogin(usuarioP, contraseniaP)){
                break; // Rompe el bucle for
            } else {
                // Si falla, avisamos (pero el bucle sigue)
                System.out.println("❌ Usuario y contraseña incorrectos");
            }
        }
        // RESULTADO FINAL
        // Verificamos cómo ha terminado la cosa
        if (intentarLogin(usuarioP, contraseniaP)){
            System.out.println("✅ ¡Bienvenido! Usuario y contraseña correctos.");
        } else {
            // Este es el mensaje que te faltaba si fallas 3 veces
            System.out.println("⛔ Has agotado tus intentos. Sistema bloqueado.");
        }
    }

    String procesarTareas(String[] tareas){

        // BUCLE FOR-EACH (Estilo Avanzado)
        // Se lee: "Para cada String 'item' dentro de la colección 'tareas'..."
        // Recorre todos los elementos uno a uno sin necesidad de usar contadores (i).
        for(String item : tareas){

            // LÓGICA DE BÚSQUEDA DEFENSIVA
            // 1. convertimos a minúsculas (.toLowerCase) para evitar problemas de mayúsculas.
            // 2. buscamos si contiene la palabra clave (.contains).
            if (item.toLowerCase().contains("urgente")){

                // RETURN ANTICIPADO (Guard Clause)
                // Si la encontramos, devolvemos esa tarea y MATAMOS el método aquí mismo.
                // No pierde tiempo mirando las siguientes tareas.
                return item;
            }
        }

        // RETORNO POR DEFECTO
        // Solo llegamos aquí si el bucle ha terminado sin encontrar nada.
        return "no hay tareas urgentes";
    }
    public void ejercicio6(){
        // Caso de prueba
        String[] tareasP = new String[]{
                "Enviar correo",
                "Enviar nota",
                "Pedir bobinas",
                "Pedir palets (URGENTE)" // Esta es la que debería cazar
        };

        // Imprimimos directamente lo que nos devuelva el método
        System.out.println(procesarTareas(tareasP));
    }

    void generarFibonacci(int limite) {

        int uno = 0;
        int dos = 0; // Empieza en 0, pero lo cambias a 1 dentro del if inicial
        int resultado = 0;

        // Bucle infinito controlado manualmente
        while (true){

            // CONFIGURACIÓN INICIAL
            // Solo entra aquí en la primera vuelta para imprimir el 0 y el 1
            if (uno == 0) {
                System.out.print(uno + ", ");
                dos = 1; // Ajustamos el segundo número
                System.out.print(dos);
            }

            // 1. CÁLCULO
            resultado = uno + dos;

            // 2. EL GUARDIÁN (Check de seguridad)
            // ¡MUY BIEN! Comprobamos ANTES de imprimir.
            // Si el resultado (ej: 13) supera al límite (10), paramos.
            if (resultado >= limite) {
                break;
            }

            // 3. IMPRESIÓN
            // Solo llegamos aquí si el número es válido
            System.out.print(", " + resultado);

            // 4. EL RELEVO
            uno = dos;
            dos = resultado;
        }
    }
    public void ejercicio7(){
        // Probamos hasta el 10 para ver si para en el 8
        generarFibonacci(10);
        // Resultado esperado: 0, 1, 1, 2, 3, 5, 8
    }

    int contarEdadesValidas(int[] edades){

        int contador=0;

        for (int i = 0; i < edades.length; i++) {

            // CLÁUSULA DE GUARDA (Filtro)
            // Si la edad es negativa O mayor de 120 (imposible humanamente)...
            if (edades[i]<0 || edades[i]>120){
                continue; // ...SALTAMOS a la siguiente vuelta del bucle.
                // Todo lo que haya debajo de esta línea se ignora para este número.
            }

            // Si llegamos aquí, es porque la edad es válida.
            // No hace falta 'else', el código fluye limpio.
            contador++;
        }
        return contador;
    }
    void mostrarEdadesValidas(int[] edades){

        System.out.println("--- Lista de Edades Válidas ---");

        for (int i = 0; i < edades.length; i++) {

            // Mismo filtro que arriba
            if (edades[i]<0 || edades[i]>120){
                continue; // Saltamos las inválidas
            }

            // Imprimimos en la misma línea separando por comas
            System.out.print(edades[i]+", ");
        }
        System.out.println(); // Salto de línea final para limpieza visual
    }
    public void ejercicio8(){
        // Creamos un array grande para probar bien
        int[] edadesP = new int[30];

        for (int i = 0; i < edadesP.length; i++) {
            // Generación Aleatoria:
            // (Math.random()*200) -> Genera de 0 a 199.
            // - 5 -> Desplaza el rango. Resultado final: de -5 a 194.
            // Esto garantiza tener negativos y gente de más de 120 años para probar el filtro.
            edadesP[i]=(int) (Math.random()*200)-5;
        }

        // Llamada 1: Contar e imprimir total
        System.out.println("Tenemos "+contarEdadesValidas(edadesP)+" edades validas");

        // Llamada 2: Mostrar el detalle
        mostrarEdadesValidas(edadesP);
    }

    int contarVocales(String texto){

        int contador = 0;

        // Recorremos el texto letra por letra
        for (int i = 0; i < texto.length(); i++) {

            // Convertimos a minúscula y analizamos el carácter actual
            switch (texto.toLowerCase().charAt(i)){
                // Agrupamos todas las vocales (Java 14+)
                case 'a','e','i','o','u' -> contador++; // Si es vocal, sumamos

                // Si es cualquier otra cosa (consonante, espacio, número...)
                default ->{
                    continue; // Saltamos a la siguiente iteración del bucle i++
                }
            }
        }
        return contador;
    }
    boolean contienePalabraProhibida(String texto, String[] palabrasProhibidas){

        // Usamos un bucle for-each para recorrer la lista de palabras malas
        for (String item : palabrasProhibidas){

            // Comprobamos si el texto contiene la palabra.
            // IMPORTANTE: Convertimos AMBOS a minúsculas para que detecte "Cansado" igual que "cansado".
            if (texto.toLowerCase().contains(item.toLowerCase())){
                return true; // ¡Alerta encontrada! Cortamos la ejecución y devolvemos true.
            }
        }
        // Si el bucle termina y no ha salido antes, es que el texto está limpio.
        return false;
    }
    String primeraPalabraLarga(String texto, int longitudMinima){

        // Troceamos la frase usando el espacio (" ") como separador
        String[] palabras = texto.split(" ");

        // Recorremos el array de palabras resultantes
        for (String item : palabras){
            // Si la palabra actual cumple el requisito de longitud...
            if (item.length() >= longitudMinima){
                return item; // ...la devolvemos inmediatamente y terminamos el método.
            }
        }
        // Mensaje de retorno por defecto si ninguna palabra era lo bastante larga
        return "no hay ninguna palabra mas larga que la longitud minima";
    }
    public void ejercicio9(){

        // Datos de prueba
        String textoP = "Estoy bastante cansado de este ejercicio";
        String[] palabras = new String[]{"ventana", "ordenador", "programar","cansado"};
        int longitudP = 7;

        // Probamos los 3 métodos
        System.out.println("El texto tiene "+contarVocales(textoP)+" vocales.");
        System.out.println("¿Contiene alguna palabra prohibida?: "+contienePalabraProhibida(textoP, palabras));
        System.out.println("La primera palabra que supera la longitud establecida es: "+primeraPalabraLarga(textoP,longitudP));
    }

   /* boolean verificarStock(int cantidad, int stock){
        if (cantidad>stock){
            return false;
        }
        return true;
    }
    double calcularDescuento(double precio, int cantidad){

        if (cantidad>4){
            return precio - (precio*0.25);
        }
        return 0;
    }
    void procesarPedidos(String[] productos, int[] cantidades, double[] precios){



    }*/

}
