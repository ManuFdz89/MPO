package Metodos;
import Enum.Moneda;
import Enum.CategoriaPlato;

import java.util.Random;
import java.util.Scanner;
import java.util.TimerTask;



public class Metodos {

    // Instanciamos el Scanner fuera del método para poder reutilizarlo si hiciera falta en otros ejercicios
    Scanner teclado = new Scanner(System.in);

    public void ejercicio1(){
        // 1. Entrada de datos
        System.out.println("Introduce tu nota: ");
        double nota = teclado.nextDouble();

        // Inicializamos la variable string. Es buena práctica darle un valor inicial (null o vacío)
        String calificacion = null;

        // 2. Validación robusta (Bucle While)
        // Mientras la nota sea menor que 0 O mayor que 10, seguimos preguntando.
        // Esto impide que el programa continúe con datos erróneos.
        while (nota < 0 || nota > 10){
            System.out.println("Introduce una nota valida (0-10): ");
            nota = teclado.nextDouble();
        }

        // 3. Lógica de clasificación (Switch)
        // TRUCO CLAVE: Hacemos un cast a (int).
        // Convertimos el double (ej: 8.9) a entero (8) para poder usar casos concretos.
        switch ((int)nota){

            // Sintaxis moderna (Java 14+): Usamos '->' que evita tener que escribir 'break' en cada línea.
            // Agrupamos casos (9 y 10) separados por comas.
            case 9, 10 -> calificacion = "A - " + "Enhorabuena has sacado sobresaliente";

            case 7, 8  -> calificacion = "B - " + "Enhorabuena has sacado notable";

            case 5, 6  -> calificacion = "C - " + "Necesitas apretar un poco";

            case 4     -> calificacion = "D - " + "Has Suspendido, pero has estado cerca";

            // Agrupamos todos los suspensos bajos (0, 1, 2, 3)
            case 0, 1, 2, 3 -> calificacion = "F - " + "Has suspendido";
        }

        // 4. Salida formateada
        // %.2f -> Muestra la nota original con 2 decimales.
        // %s -> Inserta la cadena de texto de la calificación.
        // %n -> Salto de línea.
        System.out.printf("Tu nota %.2f corresponde a una calificacion %s%n", nota, calificacion);
    }

    public void ejercicio2(){

        int opcionUsuario = 1;
        String monedaUsuario = ""; // Variable puente para guardar el nombre (texto)
        double euros = 0;

        // Bucle para mantener el menú activo mientras no se elija salir
        while (opcionUsuario <= 5 && opcionUsuario >= 1){

            // Mostramos el menú
            System.out.println("\n--- CONVERSOR DE MONEDAS ---");
            System.out.println("1. Dolar");
            System.out.println("2. Libra");
            System.out.println("3. Yen");
            System.out.println("4. Peso");
            System.out.println("5. Salir");
            System.out.print("A que moneda quieres cambiar: ");

            opcionUsuario = teclado.nextInt();

            // PASO 1: Traducir el número del menú a un String
            // (Esto nos sirve para luego buscar en el Enum)
            switch (opcionUsuario) {
                case 1 -> monedaUsuario = "Dolar";
                case 2 -> monedaUsuario = "Libra";
                case 3 -> monedaUsuario = "Yen";
                case 4 -> monedaUsuario = "Peso";
                case 5 -> {
                    // No hacemos nada aquí, el break del if de abajo se encargará
                }
            }

            // Si el usuario elige 5, rompemos el bucle while y terminamos
            if (opcionUsuario == 5){
                System.out.println("Saliendo del sistema...");
                break;
            }

            // Validación extra: Si pone un número fuera de rango (ej: 8), volvemos al inicio
            if (opcionUsuario < 1 || opcionUsuario > 5) {
                System.out.println("Opción no válida.");
                continue;
            }

            System.out.print("Introduce la cantidad de Euros a cambiar: ");
            euros = teclado.nextDouble();

            // PASO 2: Usar el Enum para calcular
            // Moneda.valueOf(String) convierte el texto "Dolar" en el objeto Moneda.Dolar
            switch (Moneda.valueOf(monedaUsuario)){

                // Dentro del switch con Enums, usamos el nombre directo (Dolar, Libra...)
                case Dolar -> {
                    // Accedemos a 'Moneda.Dolar.valorMoneda' que definiste en el otro archivo
                    double resultado = euros * Moneda.Dolar.valorMoneda;
                    System.out.printf("El cambio de %.2f € a Dólares es %.2f $%n", euros, resultado);
                }
                case Libra -> {
                    double resultado = euros * Moneda.Libra.valorMoneda;
                    System.out.printf("El cambio de %.2f € a Libras es %.2f £%n", euros, resultado);
                }
                case Yen -> {
                    double resultado = euros * Moneda.Yen.valorMoneda;
                    System.out.printf("El cambio de %.2f € a Yenes es %.2f ¥%n", euros, resultado);
                }
                case Peso -> {
                    double resultado = euros * Moneda.Peso.valorMoneda;
                    System.out.printf("El cambio de %.2f € a Pesos es %.2f $%n", euros, resultado);
                }
            }
        }
    }

    public void ejercicio3() {

        // 1. Entrada de datos
        System.out.println("introduce la temperatura: ");
        int temperatura = teclado.nextInt();

        // 2. Estructura Switch Moderna (Pattern Matching - Java 21+)
        // En lugar de comparar valores fijos, evaluamos la variable 'temperatura'.
        switch (temperatura) {

            // CASE 1: Temperaturas negativas
            // 'int t': Captura el valor de 'temperatura' en una variable temporal 't'.
            // 'when': Es la "Guarda". Solo entra si la condición (0 > t) es verdadera.
            case int t when (0 > t) -> System.out.println("Helado");

            // CASE 2: Entre 1 y 15 grados
            // Usamos '&&' para definir el rango dentro del 'when'.
            case int t when (t > 0 && t <= 15) -> System.out.println("Frío");

            // CASE 3: Entre 16 y 25 grados
            case int t when (t > 15 && t < 26) -> System.out.println("Templado");

            // CASE 4: Entre 26 y 35 grados
            case int t when (t > 25 && t < 36) -> System.out.println("Calor");

            // CASE 5: Más de 35 grados
            case int t when (t > 35) -> System.out.println("Muy caliente");

            // DEFAULT: Captura todo lo que no entró arriba
            // IMPORTANTE: Tal y como está la lógica, el 0 exacto caería aquí
            // porque en el primer case usas (0 > t) y en el segundo (t > 0).
            default -> System.out.println("valor invalido");
        }
    }

    public void ejercicio4(){

        System.out.println("¿Que quieres saber del menu?: ");
        // Tip: El bloque de texto multilínea es muy cómodo de leer
        System.out.print("""
                1. Entrada
                2. Principal
                3. Postre
                4. Bebida
                """);

        int opcion = teclado.nextInt();

        // Declaramos la variable de tipo Enum inicializada a null
        CategoriaPlato catselec = null;

        // PRIMER SWITCH: Mapear (Traducir int -> Enum)
        switch (opcion){
            case 1 -> catselec = CategoriaPlato.ENTRADA;
            case 2 -> catselec = CategoriaPlato.PRINCIPAL;
            case 3 -> catselec = CategoriaPlato.POSTRE;
            case 4 -> catselec = CategoriaPlato.BEBIDA;
            default -> {
                System.out.println("Opción no válida. Reinicia el sistema.");
                return; // ¡Excelente! Evita que el programa siga y falle abajo.
            }
        }

        // SEGUNDO SWITCH: Lógica de negocio (Usar el Enum)
        // Aquí ya trabajamos con palabras semánticas (ENTRADA, POSTRE...) no con números.
        switch (catselec){
            case ENTRADA -> {
                System.out.println("\n--- ENTRADAS ---");
                System.out.println("Ensalada");
                System.out.println("Empanada");
                System.out.println("Patatas Bravas");
            }
            case PRINCIPAL -> {
                System.out.println("\n--- PRINCIPALES ---");
                System.out.println("Filete");
                System.out.println("Pescado");
                System.out.println("Estofado");
            }
            case POSTRE -> {
                System.out.println("\n--- POSTRES ---");
                System.out.println("Tarta de limon");
                System.out.println("Tarta de queso");
                System.out.println("Tarta de fresa");
            }
            case BEBIDA -> {
                System.out.println("\n--- BEBIDAS ---");
                System.out.println("Cerveza");
                System.out.println("Vino");
                System.out.println("Refresco");
            }
        }
    }

    public void ejercicio5(){

        // 1. Entrada de datos numéricos
        System.out.println("Introduce el primer numero: ");
        double numUno = teclado.nextDouble();
        System.out.println("Introduce el segundo numero: ");
        double numDos= teclado.nextDouble();

        // 2. Entrada del operador
        System.out.println("Selecciona la operacion deseada (+, -, *, /)");
        // TRUCO: Como Scanner no tiene .nextChar(), leemos la palabra completa (.next())
        // y nos quedamos solo con la primera letra (.charAt(0)).
        char operador = teclado.next().charAt(0);

        double resultado = 0;

        // 3. Validación de seguridad (División por cero)
        // Comprobamos esto ANTES del switch para evitar errores matemáticos.
        if (operador == '/' && numDos == 0){
            System.out.println("No es posible dividir entre 0");
        } else {
            // 4. Lógica de cálculo
            switch (operador) {
                case '+' -> resultado = numUno + numDos;
                case '-' -> resultado = numUno - numDos;
                case '*' -> resultado = numUno * numDos;
                case '/' -> resultado = numUno / numDos;

                // 5. Gestión de errores de entrada
                default -> {
                    System.out.println("introduce una operacion valida");
                    // CLAVE: Este 'return' finaliza el método inmediatamente.
                    // Si entra aquí, el programa se detiene y no imprime el mensaje final.
                    return;
                }
            }
            // Solo se ejecuta si el operador fue correcto
            System.out.println("El resultado de la " + operador + " es " + resultado);
        }
    }

    private int obtenerHoraActual(){
        //Ejercicio 6, hacemos el metodo y lo llamamos desde el Main
        // Math.random() devuelve un número entre 0.0 y 0.999...
        // Al multiplicar por 24, obtenemos algo entre 0.0 y 23.999...
        // Al hacer cast a (int), cortamos los decimales y nos quedamos con el entero (0 a 23).
        int horaActual = (int) (Math.random() * 24);
        // ¡IMPORTANTE! Devolvemos el dato a quien nos haya llamado.
        return horaActual;
    }
    public void ejercicio6() {

        // LLAMADA AL MÉTODO:
        // Saltamos al método de arriba, cogemos el valor del 'return'
        // y lo guardamos en nuestra variable local 'hora'.
        int hora = obtenerHoraActual();

        // (Opcional) Imprimo la hora para verificar que el saludo coincide
        System.out.println("Son las: " + hora + ":00 horas.");

        // Lógica con Pattern Matching (Java 21)
        switch (hora) {
            // Madrugada: 0 a 5
            case int t when (t >= 0 && t <= 5) -> System.out.println("¡Es de madrugada!");

            // Mañana: 6 a 11
            case int t when (t >= 6 && t <= 11) -> System.out.println("Buenos días");

            // Tarde: 12 a 19
            case int t when (t >= 12 && t <= 19) -> System.out.println("Buenas tardes");

            // Noche: 20 a 23
            case int t when (t >= 20 && t <= 23) -> System.out.println("Buenas noches");

            // Default de seguridad (aunque con tu random nunca llegará aquí)
            default -> {
                break;
            }
        }
    }

    public void ejercicio7(){
        System.out.print("Introduce tu puntuacion: ");
        int puntuacion = teclado.nextInt();

        // Inicializamos variables. ¡Bien hecho!
        String textoPuntuacion = "";
        String motivacional = "";

        switch (puntuacion){
            // Caso 1: Menos de 100 (incluye negativos, para un juego simple está bien)
            case int t when (t <= 100) -> {
                textoPuntuacion = "Principiante";
                motivacional = "¡Tú puedes!";
            }
            // Caso 2: De 101 a 500
            case int t when (t > 100 && t <= 500) -> {
                textoPuntuacion = "Intermedio";
                motivacional = "Has mejorado";
            }
            // Caso 3: De 501 a 1000
            case int t when (t > 500 && t <= 1000) -> {
                textoPuntuacion = "Avanzado";
                motivacional = "Sigue así";
            }
            // Caso 4: De 1001 a 5000
            case int t when (t > 1000 && t <= 5000) -> {
                textoPuntuacion = "Experto";
                motivacional = "¡Increíble!";
            }
            // Caso 5: Más de 5000
            case int t when (t > 5000) -> {
                textoPuntuacion = "Maestro";
                motivacional = "¡Eres el mejor!";
            }
            // Default: Solo por seguridad, aunque tu lógica cubre todos los números posibles
            default -> {
                System.out.println("Error inesperado.");
                return; // Salimos para no imprimir nada abajo
            }
        }

        // CORRECCIÓN PEQUEÑA: Añadido %n al final para el salto de línea
        System.out.printf("Tu puntuacion %d corresponde a la categoría %s. %s%n",
                puntuacion, textoPuntuacion, motivacional);
    }

    public void ejercicio8(){

        System.out.println("Introduce la extension: ");

        // CLAVE: Usamos .toLowerCase()
        // Esto convierte lo que escriba el usuario (ej: "JPG", "Jpg") a minúsculas ("jpg").
        // Así nos aseguramos de que coincida con los casos del switch.
        String nombreArchivo = teclado.next().toLowerCase();

        String programa = "";

        switch (nombreArchivo){
            // AGRUPACIÓN DE CASOS
            // Java permite poner varios strings separados por comas para que ejecuten el mismo código.
            case "jpg", "png", "gif" -> {
                System.out.println("Imagenes");
                programa = "Visor de imagenes de Windows";
            }
            case "pdf", "doc", "txt" -> {
                System.out.println("Documentos");
                programa = "Adobe";
            }
            case "mp3", "wav" -> {
                System.out.println("Audio");
                programa = "Vlc media";
            }
            case "mp4", "avi" -> {
                System.out.println("Video");
                programa = "Vlc media";
            }
            // DEFAULT DE SEGURIDAD
            default -> {
                System.out.println("selecciona una extension valida");
                // ¡MUY BIEN! Este 'return' es vital.
                // Si entra aquí, el método se acaba inmediatamente y no imprime el mensaje final erróneo.
                return;
            }
        }

        // Si llegamos aquí, es porque la extensión era válida y tenemos un 'programa' asignado.
        System.out.printf("has seleccionado %s, el programa recomendado para abrirlo es %s", nombreArchivo, programa);
    }

    public void ejercicio9(){
        System.out.println("Introduce tu peso en kg: ");
        double peso = teclado.nextDouble();
        System.out.println("Introduce tu altura en metros: ");
        double altura = teclado.nextDouble();

        double imc = peso/(altura*altura);
        String categoria = "";

        switch (imc){
            case double t when (t<18.5) -> categoria = "Bajo peso";
            case double t when (t>18.5 && t<25) -> categoria = "Normal";
            case double t when (t>=25 && t<=29.9) -> categoria = "Sobrepeso";
            case double t when (t>=30) -> categoria = "Obesidad";
            default -> {
                System.out.println("Error");
                return;
            }
        }
        System.out.printf("Tu IMC es %.2f, clasificado %s",imc, categoria);
    }


}
