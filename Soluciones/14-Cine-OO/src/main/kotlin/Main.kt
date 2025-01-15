package dev.joseluisgs

import models.Butaca
import models.Configuracion
import models.Sala
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    println("Hola Cine")

    // Argumentos tienen que ser 2
    val config = validacionArgumentos(args)

    val sala = Sala(config.filas, config.columnas)
    imprimirSala(sala)

    var opcion: Int

    do {
        println("1. Ver sala")
        println("2. Comprar Entrada")
        println("3. Devolver Entrada")
        println("4. Ver Recaudación")
        println("5. Encontrar primera butaca libre")
        println("0. Salir")

        opcion = readln().toIntOrNull() ?: -1

        when (opcion) {
            1 -> imprimirSala(sala)
            2 -> comprarEntrada(sala)
            3 -> devolverEntrada(sala)
            4 -> verRecaudacion(sala)
            5 -> encontrarPrimeraButacaLibre(sala)
            0 -> despedida()
            else -> println("Opción no válida")
        }

    } while (opcion != 0)

}

fun encontrarPrimeraButacaLibre(sala: Sala) {
    try {
        val posicion = sala.getButacaLibre()
        println("La primera butaca libre es: ${posicion.fila}:${posicion.columna + 1}")
    } catch (e: Exception) {
        println("No hay butacas libres")
    }
}

/**
 * Función que muestra la recaudación de la sala
 * @param sala Sala a mostrar la recaudación
 */
fun verRecaudacion(sala: Sala) {
    val recaudacion =
        sala.getRecaudacion(Butaca.Tipo.NORMAL) + sala.getRecaudacion(Butaca.Tipo.ESPECIAL) + sala.getRecaudacion(
            Butaca.Tipo.VIP
        )
    println("La recaudación total es de $recaudacion")
    println("La recaudación de butacas normales es de ${sala.getRecaudacion(Butaca.Tipo.NORMAL)}€")
    println("La recaudación de butacas especiales es de ${sala.getRecaudacion(Butaca.Tipo.ESPECIAL)}€")
    println("La recaudación de butacas vip es de ${sala.getRecaudacion(Butaca.Tipo.VIP)}€")
}

/**
 * Función que se ejecuta al salir del programa
 */
fun despedida() {
    println("Adiós Cine")
}

/**
 * Función que devuelve una entrada
 * @param sala Sala a devolver la entrada
 */
fun devolverEntrada(sala: Sala) {
    if (sala.isVacia()) {
        println("La sala está vacía, no hay entradas para devolver")
        return
    }
    val asiento = getAsiento(sala, true)
    sala.actualizarButaca(asiento[0], asiento[1], false)
    val fila: Char = (asiento[0] + 65).toChar()
    println("Butaca devuelta: $fila:${asiento[1] + 1} ha sido devuelta")
}

/**
 * Función que compra una entrada
 * @param sala Sala a comprar la entrada
 */
fun comprarEntrada(sala: Sala) {
    if (sala.isLlena()) {
        println("La sala está llena, no se pueden comprar más entradas")
        return
    }
    val asiento = getAsiento(sala, false)
    sala.actualizarButaca(asiento[0], asiento[1], true)
    val fila: Char = (asiento[0] + 65).toChar()
    println("Butaca reservada: $fila:${asiento[1] + 1} ha sido reservada")
}

/**
 * Función que pide una butaca
 * @param sala Sala a pedir la butaca
 * @param isOcupada Si la butaca está ocupada o no
 * @return Butaca
 */
private fun getAsiento(sala: Sala, isOcupada: Boolean = false): IntArray {
    var correcto = true
    var fila = ""
    var columna = 0
    var filaInt = 0
    var colInt = 0

    do {
        val asiento = inputAsiento()
        fila = asiento.split(":")[0].uppercase()
        columna = asiento.split(":")[1].toIntOrNull() ?: 0

        // Comprobamos que la columna sea valida dentro de las dimensiones de la sala
        correcto = validateFilasColumnas(sala, fila, columna)

        filaInt = fila[0].code - 65 // Restamos 65 para obtener el índice de la fila
        colInt = columna - 1 // Restamos 1 para obtener el índice de la columna

        // Si vamos a reservar, isOcupada = false, si vamos a devolver, isOcupada = true

        correcto = isAsientoOcupado(sala, filaInt, colInt, isOcupada)

    } while (!correcto)
    return intArrayOf(filaInt, colInt)
}

/**
 * Función que comprueba si una butaca está ocupada o no
 * @param sala Sala a comprobar la butaca
 * @param filaInt Fila de la butaca
 * @param colInt Columna de la butaca
 * @param ocupada Si la butaca está ocupada o no
 */
fun isAsientoOcupado(sala: Sala, filaInt: Int, colInt: Int, ocupada: Boolean): Boolean {
    if (sala.isOcupada(filaInt, colInt) == !ocupada) {
        println("La butaca no está disponible (reservada), elige otra butaca")
        return false
    }
    return true
}

/**
 * Función que valida las filas y columnas
 * @param sala Sala a validar las filas y columnas
 * @param fila Fila a validar
 * @param columna Columna a validar
 */
fun validateFilasColumnas(sala: Sala, fila: String, columna: Int): Boolean {
    if ((columna - 1) !in 0..sala.columnas) {
        println("La columna no es válida, debe ser un número entre 1 y ${sala.columnas}")
        return false
    }
    // Comprobamos que la fila sea válida dentro de las dimensiones de la sala
    // El string de la fila lo convertimos a char y obtenemos el código ASCII
    // El intervalo de las letras mayúsculas en ASCII es de 65 al indice de la última letra (dimension)
    if (fila[0].code !in 65..(65 + sala.filas)) {
        println("La fila no es válida, debe ser una letra entre A y ${sala.filas + 64}")
        return false
    }
    return true
}

/**
 * Función que pide una butaca
 * @return Butaca en formato String
 */
fun inputAsiento(): String {
    println("Dime la fila y la columna de la butaca que quieres, A:1, B:2, C:3, etc.: ")
    val regexInput = Regex("[A-Z]:[1-9]")
    var input = ""
    var correcto = true
    do {
        input = readln().trim().uppercase()
        if (!regexInput.matches(input)) {
            println("El formato no es válido, debe ser letra:numero, por ejemplo A:1")
            correcto = false
        }
    } while (!regexInput.matches(input))
    return input
}

/**
 * Función que imprime la sala
 * @param sala Sala a imprimir
 */
private fun imprimirSala(sala: Sala) {
    println(sala)
}

/**
 * Función que valida los argumentos pasados por consola
 * @param args Argumentos pasados por consola
 * @return Configuración del cine
 */
private fun validacionArgumentos(args: Array<String>): Configuracion {
    if (args.size != 2) {
        mensajeErrorValidacionArgumentos()
    }
    val filas = args[0]
    val columnas = args[1]

    if (!filas.lowercase().startsWith("filas:") || !columnas.lowercase().startsWith("columnas:")) {
        mensajeErrorValidacionArgumentos()
    }

    val filasInt = filas.substringAfter(":").toIntOrNull() ?: 0
    val columnasInt = columnas.substringAfter(":").toIntOrNull() ?: 0

    if (filasInt !in 3..5 || columnasInt !in 3..5) {
        mensajeErrorValidacionArgumentos()
    }
    return Configuracion(filasInt, columnasInt)
}

/**
 * Función que muestra un mensaje de error y sale del programa
 */
private fun mensajeErrorValidacionArgumentos() {
    println("Error: Argumentos inválidos: No ha pasado los argumentos correctos o no son válidos")
    println("Ejemplo: java -jar cine.jar filas:3 columnas:3")
    println("Filas: entre 3 y 5")
    println("Columnas: entre 3 y 5")
    exitProcess(0)
}