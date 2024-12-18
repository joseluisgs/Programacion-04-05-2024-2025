package dev.joseluisgs.models

abstract class Jugador(
    nombre: String,
    edad: Int,
    val dorsal: Int,
) : Persona(nombre, edad) {

    override fun toString(): String {
        return "Jugador(nombre='$nombre', edad=$edad, dorsal=$dorsal)"
    }

    fun jugar() {
        println("Jugador: Vamos a jugar")
    }

    abstract fun entrenar(nivelEsfuerzo: Int)
}
