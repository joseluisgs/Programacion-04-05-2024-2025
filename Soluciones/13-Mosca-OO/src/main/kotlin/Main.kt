package dev.joseluisgs

import com.github.ajalt.mordant.rendering.TextColors
import com.github.ajalt.mordant.rendering.TextColors.green
import com.github.ajalt.mordant.rendering.TextColors.red
import com.github.ajalt.mordant.terminal.Terminal
import mosca.CazaMoscas
import mosca.Configuracion
import mosca.NUM_INTENTOS_DEFAULT
import mosca.TAM_DEFAULT
import kotlin.system.exitProcess

val terminal = Terminal()

/**
 * Juego de cazar la mosca en un vector
 * @author JoseLuisGS
 * @version 1
 */
fun main(args: Array<String>) {
    // Analizamos los argumentos
    val configuracion = analizarArgumentos(args)

    // Presentación del juego
    println("Iniciando el juego de la mosca con los siguientes parámetros:")
    println("Tamaño del vector: ${configuracion.tam}")
    println("Número de intentos: ${configuracion.numIntentos}")


    // val juego = CazaMoscas(configuracion.tam, configuracion.numIntentos)
    //v al juego = CazaMoscas.create(configuracion.tam, configuracion.numIntentos)
    //  val juego = CazaMoscas.create("5:2")
    // val juego = CazaMoscas.create()
    val juego = CazaMoscas.create(configuracion)

    val result = juego.jugar()
    if (result) {
        terminal.println(green("Has ganado y has cazado la mosca en menos de ${configuracion.numIntentos} intentos"))
    } else {
        terminal.println(red("Has perdido y no has podido cazar la mosca en ${configuracion.numIntentos} intentos"))
    }
    // Imprimimos el vector
    juego.imprimir()
}

/**
 * Analiza los argumentos de entrada y devuelve un array con los valores
 * @param args Array de argumentos de entrada
 * @return Array de enteros con los valores de los argumentos para el juego con tam y numIntentos
 */
private fun analizarArgumentos(args: Array<String>): Configuracion {
    if (args.size != 4) {
        terminal.println(red("Error en los argumentos"))
        terminal.println("Uso: java -jar mosca.jar -tam 8 -numIntentos 5")
        exitProcess(1)
    }
    // Hay que analizar los argumentos
    // Buscamos que dentro del argumentos exista -tam y el siguiente es su valor
    // Si no existe damos un warning y ponemos el valor por defecto
    // Si existe y el valor no es un entero damos un warning y ponemos el valor por defecto
    // Si existe y el valor es un entero lo guardamos
    val existeTam = buscarEnArgs(args, "-tam")
    var tam: Int = TAM_DEFAULT
    if (existeTam == -1) {
        terminal.println(TextColors.yellow("No existe el argumento -tam"))
        terminal.println("Uso: java -jar mosca.jar -tam 8 -numIntentos 5")
        exitProcess(1)
    }
    if (args[existeTam + 1].toIntOrNull() == null) {
        terminal.println(TextColors.yellow("El valor de -tam no es un entero"))
        println("usando el valor por defecto $TAM_DEFAULT")
    } else {
        tam = args[existeTam + 1].toInt()
    }
    // Buscamos que dentro del argumentos exista -numIntentos y el siguiente es su valor
    // Si no existe damos un warning y ponemos el valor por defecto
    // Si existe y el valor no es un entero damos un warning y ponemos el valor por defecto
    // Si existe y el valor es un entero lo guardamos
    val existeNumIntentos = buscarEnArgs(args, "-numIntentos")
    var numIntentos: Int = NUM_INTENTOS_DEFAULT
    if (existeNumIntentos == -1) {
        terminal.println(TextColors.yellow("No existe el argumento -numIntentos"))
        terminal.println("Uso: java -jar mosca.jar -tam 8 -numIntentos 5")
        exitProcess(1)
    }
    if (args[existeNumIntentos + 1].toIntOrNull() == null) {
        terminal.println(TextColors.yellow("El valor de -numIntentos no es un entero"))
        println("usando el valor por defecto $NUM_INTENTOS_DEFAULT")
    } else {
        numIntentos = args[existeNumIntentos + 1].toInt()
    }
    return Configuracion(tam, numIntentos)
}


/**
 * Busca una cadena dentro de un array de cadenas
 * @param args Array de cadenas
 * @param cadena Cadena a buscar
 * @return Posición de la cadena dentro del array o -1 si no existe
 */
private fun buscarEnArgs(args: Array<String>, cadena: String): Int {
    for (i in args.indices) {
        if (args[i] == cadena) {
            return i
        }
    }
    return -1
}
