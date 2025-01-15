package dev.joseluisgs.models

abstract class Persona(
    val nombre: String,
    val edad: Int,
) {


    override fun toString(): String {
        return "Persona(nombre='$nombre', edad=$edad)"
    }

    fun presentarse() {
        println("Persona: Hola, soy $nombre y tengo $edad años")
    }

    abstract fun saludar()
}