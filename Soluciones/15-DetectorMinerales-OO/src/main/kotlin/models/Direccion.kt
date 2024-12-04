package models

import kotlin.random.Random

class Direccion private constructor(var fila: Int, var columna: Int) {

    fun thinkNewDirection(probDecision: Int) {
        if (Random.nextInt(100) < probDecision) {
            println("He decidido cambiar de Direccion, me lo pienso...")
            val direction = random()
            if (direction.fila == this.fila && direction.columna == this.columna) {
                println("...No cambio de Direccion")
            } else {
                println("...Cambio de Direccion")
                this.fila = direction.fila
                this.columna = direction.columna
            }
        }
    }

    companion object {
        fun random(): Direccion {
            var nuevaDireccionFila = 0
            var nuevaDireccionColumna = 0
            do {
                nuevaDireccionFila = intArrayOf(-1, 0, 1).random()
                nuevaDireccionColumna = (-1..1).random()
            } while (nuevaDireccionFila == 0 && nuevaDireccionColumna == 0)
            return Direccion(nuevaDireccionFila, nuevaDireccionColumna)
        }
    }

    override fun toString(): String {
        // ("Direccion de Busqueda: ${direccionBusqueda.joinToString()}")
        val direccion = StringBuilder("Direccion de Busqueda: ")
        when (this.fila) {
            -1 -> direccion.append("N")
            1 -> direccion.append("S")
        }
        when (this.columna) {
            -1 -> direccion.append("O")
            1 -> direccion.append("E")
        }
        return direccion.toString()
    }

}