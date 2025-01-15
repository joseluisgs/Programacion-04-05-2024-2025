package dev.joseluisgs.models

class RolCentrocampistaImpl(override val dorsal: Int = 1) : RolCentrocampista {

    override fun distribuir() {
        println("Centrocampista: Distribuyendo")
    }

    override fun entrenar() {
        println("Centrocampista: Entrenando")
    }

    override fun toString(): String {
        return " soy un Centrocampista con dorsal $dorsal"
    }
}