package dev.joseluisgs.models

class RolEntrenadorImpl : IEntrenador {
    override fun alinearEquipo() {
        println("Entrenador: Alineando equipo")
    }

    override fun entrenar() {
        println("Entrenador: Entrenando")
    }

    override fun toString(): String {
        return " soy un Entrenador"
    }
}