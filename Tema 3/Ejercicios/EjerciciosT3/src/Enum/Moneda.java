package Enum;

// Definimos el Enum con propiedades (variables) y constructor
public enum Moneda {

    // 1. LAS CONSTANTES
    // Definimos los tipos de moneda y pasamos los valores al constructor.
    // (valorEuro referencia = 1, valorMoneda = tipo de cambio respecto al euro)
    Dolar(1, 1.16),
    Libra(1, 0.88),
    Yen(1, 177.67),
    Peso(1, 21.35);

    // 2. LOS ATRIBUTOS (CAMPOS)
    // Usamos 'final' porque el tipo de cambio de este Enum no debería cambiar durante la ejecución
    public final double valorEuro;
    public final double valorMoneda;

    // 3. EL CONSTRUCTOR
    // Este constructor es privado implícitamente. Se ejecuta automáticamente
    // cuando Java crea las constantes (Dolar, Libra...) al iniciar el programa.
    Moneda (double valorEuroP, double valorMonedaP){
        valorEuro = valorEuroP;     // Asignamos el valor recibido al atributo
        valorMoneda = valorMonedaP; // Asignamos el tipo de cambio
    }

    // Al tener estos datos aquí dentro, hemos "encapsulado" la información.
}
