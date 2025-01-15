package dev.joseluisgs.models

class RolDelanteroImpl(override val dorsal: Int = 1) : RolDelantero {

    override fun marcar() {
        println("Delantero: Marcando")
    }

    override fun entrenar() {
        println("Delantero: Entrenando")
    }

    override fun toString(): String {
        return " soy un Delantero con dorsal $dorsal"
    }
}