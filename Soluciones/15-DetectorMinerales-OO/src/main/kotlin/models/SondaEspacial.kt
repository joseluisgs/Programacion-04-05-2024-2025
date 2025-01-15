package models

import kotlin.random.Random

class SondaEspacial(private val config: Configuracion) {
    private val map = crearMapa()


    private fun crearMapa(): Array<Array<Mineral>> {
        val map = Array(config.size) { Array<Mineral>(config.size) { Mineral(0) } }
        for (i in map.indices) {
            for (j in map.indices) {
                map[i][j] = Mineral(Random.nextInt(config.maxValue))
            }
        }
        return map
    }

    fun simulacion() {
        var time = 1
        var cantidadMineral = 0
        var direccionBusqueda = Direccion.random()
        var posicionActual = Posicion.getInitial(config.size)

        do {
            println()
            println("Tiempo: $time")
            println("Cantidad de Mineral: $cantidadMineral")
            println(posicionActual)
            println(direccionBusqueda)
            printTablero(posicionActual)

            // ACCION
            cantidadMineral += buscarMineral(posicionActual)

            if (time % 2 == 0) {
                direccionBusqueda.thinkNewDirection(config.probDecision)
            }

            // Si he llegado al final del mapa, cambio de direccion
            while (isEndMap(posicionActual, direccionBusqueda)) {
                direccionBusqueda = Direccion.random()
            }

            // Muevo la posicion actual
            posicionActual.getNuevaPosicionFrom(direccionBusqueda)

            Thread.sleep(config.pauseTime)
            time++
        } while (hayMineral() && time <= config.maxTime)

        println()
        println("Fin de la Exploracion")
        println("Tiempo: $time")
        println("Cantidad de Mineral: $cantidadMineral")
        println(posicionActual)
        printTablero(posicionActual)
        println(this)
    }

    override fun toString(): String {
        val builder = StringBuilder()
        // imprimo un mapa encima donde [ ] libre y [X] soy yo
        for (i in map.indices) {
            for (j in map.indices) {
                builder.append("[${map[i][j]}]")
            }
            builder.append("\n")
        }
        return builder.toString()
    }

    private fun printTablero(posicionActual: Posicion) {
        for (i in 0..<config.size) {
            for (j in 0..<config.size) {
                if (i == posicionActual.fila && j == posicionActual.columna) {
                    print("[🤖]")
                } else {
                    print("[${map[i][j]}]")
                }
            }
            println()
        }
        println()
    }


    private fun isEndMap(posicionActual: Posicion, direccionBusqueda: Direccion): Boolean {
        // Estamos en el extremo del mapa y vamos a salirnos
        // Si estamos en la posicion 0 y vamos hacia el norte
        // Si estamos en la posicion SIZE - 1 y vamos hacia el sur
        // Si estamos en la posicion 0 y vamos hacia el oeste
        // Si estamos en la posicion SIZE - 1 y vamos hacia el este
        return posicionActual.fila == 0 && direccionBusqueda.fila == -1
                || posicionActual.fila == config.size - 1 && direccionBusqueda.fila == 1
                || posicionActual.columna == 0 && direccionBusqueda.columna == -1
                || posicionActual.columna == config.size - 1 && direccionBusqueda.columna == 1
    }

    private fun buscarMineral(posicionActual: Posicion): Int {
        return if (map[posicionActual.fila][posicionActual.columna].cantidad > 0) {
            println("Mineral encontrado en la posicion f:${posicionActual.fila + 1}, c:${posicionActual.columna + 1}")
            if (Random.nextInt(100) < config.probTakeMineral) {
                println("Mineral tomado, cantidad: ${config.numMineralsTaken}")
                if (map[posicionActual.fila][posicionActual.columna].cantidad >= config.numMineralsTaken) {
                    map[posicionActual.fila][posicionActual.columna].cantidad -= config.numMineralsTaken
                    config.numMineralsTaken
                } else {
                    val cantidad = map[posicionActual.fila][posicionActual.columna].cantidad
                    map[posicionActual.fila][posicionActual.columna].cantidad = 0
                    cantidad
                }
            } else {
                println("Mineral no tomado")
                0
            }
        } else {
            println("No hay mineral en la posicion f:${posicionActual.fila + 1}, c:${posicionActual.columna + 1}")
            0
        }
    }


    private fun hayMineral(): Boolean {
        for (i in map.indices) {
            for (j in map.indices) {
                if (map[i][j].cantidad > 0) {
                    return true
                }
            }
        }
        return false
    }

}