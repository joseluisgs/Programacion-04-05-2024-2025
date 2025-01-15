package dev.joseluisgs.models

class RolPorteroImpl(override val dorsal: Int = 1) : RolJugador, RolPortero {

    override fun parar() {
        println("Portero: Parando")
    }

    override fun entrenar() {
        println("Portero: Entrenando")
    }

    override fun toString(): String {
        return " soy un Portero con dorsal $dorsal"
    }
}