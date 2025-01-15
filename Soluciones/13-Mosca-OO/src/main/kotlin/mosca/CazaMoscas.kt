package mosca

import com.github.ajalt.mordant.rendering.TextColors.*
import com.github.ajalt.mordant.terminal.Terminal
import mosca.CazaMoscas.Golpeo.*

typealias Tablero = Array<Array<Mosca?>>


val terminal = Terminal()

class CazaMoscas private constructor(
    private val tamTablero: Int = TAM_DEFAULT,
    private val numIntentos: Int = NUM_INTENTOS_DEFAULT
) {
    // Matriz de mosca
    private val matriz: Tablero = Array(tamTablero) { Array(tamTablero) { null } }
    private val mosca = Mosca()

    companion object {
        fun create(tamTablero: Int = TAM_DEFAULT, numIntentos: Int = NUM_INTENTOS_DEFAULT): CazaMoscas {
            require(tamTablero > 2) { "El tamaño del tablero debe ser mayor que 2" }
            require(numIntentos > 1) { "El número de intentos debe ser mayor que 1" }
            return CazaMoscas(tamTablero, numIntentos)
        }

        fun create(configuracion: Configuracion): CazaMoscas {
            return CazaMoscas(configuracion.tam, configuracion.numIntentos)
        }

        fun create(configuracion: String): CazaMoscas {
            val config = configuracion.split(" ")
            val tam = config[1].toIntOrNull()
            val numIntentos = config[3].toIntOrNull()
            require(tam != null && numIntentos != null) { "El formato de la configuracion es incorrecto" }
            require(tam > 2) { "El tamaño del tablero debe ser mayor que 2" }
            require(numIntentos > 1) { "El número de intentos debe ser mayor que 1" }
            return CazaMoscas(tam, numIntentos)
        }
    }

    /**
     * Juega a cazar la mosca en un vector
     * @return true si se ha cazado la mosca, false si no se ha cazado
     */
    fun jugar(): Boolean {
        var intentos = 0
        var moscaMuerta = false
        // La primera vez sorteamos la posición de la mosca
        sortearPosicionMosca()
        //imprimir() // TODO Quitar en producción

        // Comenzamos el juego
        do {
            // Aumentamos el número de intentos
            intentos++
            // Pedimos la posición valida paara analizar el vector
            val posicion = pedirPosicionValida()
            // analizamos la posición
            val resultado = analizarGolpeo(posicion)
            when (resultado) {
                GOLPEO_ACERTADO -> {
                    val mosca = matriz[posicion.fila][posicion.columna] as Mosca
                    mosca.kill()
                    if (mosca.isAlive) {
                        terminal.println(green("🪰 ¡HAS DADO A LA MOSCA! pero no la has matado en el intento $intentos"))
                        terminal.println(green("🪰 La mosca revoltea y cambia de posición"))
                        sortearPosicionMosca()
                        println("Mosca tiene ahora: ${mosca.maxVidas}")
                        //imprimir() // TODO Quitar en producción
                    } else {
                        terminal.println(green("☠️ ¡TE LA HAS CARGADO! has acertado en el intento $intentos"))
                        moscaMuerta = true
                    }
                }

                GOLPEO_CASI -> {
                    terminal.println(yellow("🫤 ¡CASI! Has estado cerca en el intento $intentos"))
                    terminal.println(yellow("🪰 La mosca revoltea y cambia de posición"))
                    sortearPosicionMosca()
                    //imprimir() // TODO Quitar en producción
                }

                GOLPEO_FALLADO -> {
                    terminal.println(red("Has fallado en el intento $intentos"))
                }
            }

        } while (!moscaMuerta && intentos < numIntentos)
        return moscaMuerta
    }

    /**
     * Analiza el golpeo de la mosca en el vector
     * @param posicion Posición del vector a analizar
     * @return GOLPEO_ACERTADO si la mosca está en esa posición, GOLPEO_FALLADO si no está en esa posición
     * @see Golpeo
     */
    private fun analizarGolpeo(posicion: Posicion): Golpeo {

        // Si la posición es MOSCA, la mosca está en esa posición, devolvemos GOLPEO_ACERTADO
        if (matriz[posicion.fila][posicion.columna] is Mosca) {
            return GOLPEO_ACERTADO
        }
        // Son lo mismo
        /* if (matriz[posicion.fila][posicion.columna] != null) {
             return GOLPEO_ACERTADO
         }*/


        // Mirar la mosca en una posición adyacente valida de las 8 direcciones posibles,
        // devolvemos GOLPEO_CASI si esta es una posición válida
        // Filas: fila-1, fila, fila+1
        for (i in -1..1) {
            // Columnas: columna-1, columna, columna+1
            for (j in -1..1) {
                // Obtenemos la nueva posición a analizar
                val nuevaFila = posicion.fila + i
                val nuevaColumna = posicion.columna + j
                // Comprobamos que la nueva posición es válida dentro de los límites
                if (nuevaFila in matriz.indices && nuevaColumna in matriz[0].indices) {
                    // Analizamos si la nueva posición es MOSCA
                    // Ahora lo hacemos así o con el is Mosca como antes
                    if (matriz[nuevaFila][nuevaColumna] != null) {
                        return GOLPEO_CASI
                    }
                }
            }
        }

        // Si no, la mosca no está en esa posición, devolvemos GOLPEO_FALLADO
        return GOLPEO_FALLADO
    }

    /**
     * Pide una posición válida para el vector
     * @return Posición válida del vector
     */
    private fun pedirPosicionValida(): Posicion {
        var inputIsOk = false
        val inputRegex = "^[0-9]+:[0-9]+\$".toRegex()
        var filaFinal = 0
        var columnaFinal = 0
        do {
            print("Introduce una posición válida como fila:columna-> ")
            val input = readln().trim()
            if (input.matches(inputRegex)) {
                // Cogemos cada parte del input y la convertimos a entero usando el split de :
                val fila = input.split(":")[0].toInt()
                val columna = input.split(":")[1].toInt()

                // Comprobamos que la fila y la columna están dentro del rango del vector
                if (fila in 1..matriz.size && columna in 1..matriz[0].size) {
                    filaFinal = fila - 1
                    columnaFinal = columna - 1
                    inputIsOk = true
                }
            }
            if (!inputIsOk) {
                terminal.println(red("La posición no es válida. Inténtalo de nuevo con valores entre 1 y ${matriz.size}"))
            }
        } while (!inputIsOk)
        return Posicion(filaFinal, columnaFinal)
    }

    /**
     * Imprime un vector de enteros
     */
    fun imprimir() {
        for (i in matriz.indices) {
            for (j in matriz[i].indices) {
                if (matriz[i][j] != null) {
                    //print("[🪰]")
                    print("[${matriz[i][j]}]")
                } else {
                    print("[  ]")
                }
            }
            println()
        }
        println()
    }

    /**
     * Sortea la posición de la mosca en el vector
     */
    private fun sortearPosicionMosca() {
        // Ponemos todas las posiciones a VACIO
        for (i in matriz.indices) {
            for (j in matriz[i].indices) {
                matriz[i][j] = null
            }
        }
        // Sorteamos la posición de la mosca
        val posicionMoscaFila = matriz.indices.random()
        val posicionMoscaColumna = matriz[posicionMoscaFila].indices.random()
        matriz[posicionMoscaFila][posicionMoscaColumna] = mosca
    }

    /**
     * Enumerado de los posibles golpeos
     * @property GOLPEO_ACERTADO: Golpeo acertado
     * @property GOLPEO_CASI: Golpeo casi acertado
     * @property GOLPEO_FALLADO: Golpeo fallado
     */
    enum class Golpeo {
        GOLPEO_ACERTADO,
        GOLPEO_CASI,
        GOLPEO_FALLADO
    }

}
