package dev.joseluisgs.models

class RolDefensaImpl(override val dorsal: Int = 1) : RolDefensa {

    override fun defender() {
        println("Defensa: Defendiendo")
    }

    override fun entrenar() {
        println("Defensa: Entrenando")
    }

    override fun toString(): String {
        return " soy un Defensa con dorsal $dorsal"
    }
}