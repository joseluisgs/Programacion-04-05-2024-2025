package models

import dev.joseluisgs.models.Posicion

typealias Butacas = Array<Array<Butaca>>

class Sala(
    val filas: Int = 3,
    val columnas: Int = 3,
) {
    val butacas: Butacas = Array(filas) { Array(columnas) { Butaca.random() } }

    override fun toString(): String {
        val resultado = StringBuilder()
        /* for (fila in butacas.indices) {
             // Ponemos A, B, C, D, E por cada fila
             resultado.append("[" + getLetraFila(fila) + "]")
             for (butaca in butacas[fila].indices) {
                 resultado.append(butacas[fila][butaca])
             }
             resultado.append("\n")
         }*/
        // Otra forma de hacerlo porque no necesito el índice de la fila
        // ni de la columna, solo recorrer las butacas
        // indexOf devuelve el índice de la fila
        for (fila in butacas) {
            resultado.append("[" + getLetraFila(butacas.indexOf(fila)) + "]")
            for (butaca in fila) {
                resultado.append(butaca)
            }
            resultado.append("\n")
        }
        return resultado.toString()
    }

    /**
     * Devuelve la letra de la fila según el número de fila.
     * La letra A es el número 65 en ASCII, por lo que sumando el número de fila
     * obtenemos la letra correspondiente.
     * Ejemplo:
     * A = 65 + 0 -> 65 -> A
     * B = 65 + 1 -> 66 -> B
     * C = 65 + 2 -> 67 -> C
     * D = 65 + 3 -> 68 -> D
     * @param fila Número de fila
     * @return Letra de la fila
     */
    private fun getLetraFila(fila: Int) = (65 + fila).toChar()

    /**
     * Devuelve la recaudación de una sala según el tipo de butaca
     */
    fun getRecaudacion(tipo: Butaca.Tipo): Double {
        var recaudacion = 0.0
        for (fila in butacas.indices) {
            for (butaca in butacas[fila].indices) {
                if (butacas[fila][butaca].tipo == tipo && butacas[fila][butaca].ocupada) {
                    recaudacion += butacas[fila][butaca].tipo.precio
                }
            }
        }
        return recaudacion
    }

    fun isOcupada(fila: Int, columna: Int): Boolean {
        return butacas[fila][columna].ocupada
    }

    /**
     * Actualiza el estado de una butaca
     * @param fila Número de fila
     * @param columna Número de columna
     * @param isOcupada Estado de la butaca
     */
    fun actualizarButaca(fila: Int, columna: Int, isOcupada: Boolean) {
        butacas[fila][columna].ocupada = isOcupada
    }

    /**
     * Comprueba si la sala está llena
     * @return Devuelve true si la sala está llena, false en caso contrario
     */
    fun isLlena(): Boolean {
        // Para que este llena todas las butacas deben estar ocupadas
        val totalButacas = filas * columnas
        var ocupadas = 0
        for (fila in butacas.indices) {
            for (butaca in butacas[fila].indices) {
                if (butacas[fila][butaca].ocupada) {
                    ocupadas++
                }
            }
        }
        return totalButacas == ocupadas
    }

    /**
     * Comprueba si la sala está vacía
     * @return Devuelve true si la sala está vacía, false en caso contrario
     */
    fun isVacia(): Boolean {
        for (fila in butacas.indices) {
            for (butaca in butacas[fila].indices) {
                if (!butacas[fila][butaca].ocupada) {
                    return false
                }
            }
        }
        return true
    }

    fun hayButacasLibres(): Boolean {
        for (fila in butacas.indices) {
            for (butaca in butacas[fila].indices) {
                if (!butacas[fila][butaca].ocupada) {
                    return true
                }
            }
        }
        return false
    }

    fun getButacaLibre(): Posicion {
        for (fila in butacas.indices) {
            for (butaca in butacas[fila].indices) {
                if (!butacas[fila][butaca].ocupada) {
                    return Posicion(getLetraFila(fila), butaca)
                }
            }
        }
        throw Exception("No hay butacas libres")
    }
}