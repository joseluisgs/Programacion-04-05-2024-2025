package dev.joseluisgs.models

class Entrenador(
    nombre: String,
    edad: Int,
    val experiencia: Int,
) : Persona(nombre, edad) {

    override fun toString(): String {
        return "Entrenador(nombre='$nombre', edad=$edad, experiencia=$experiencia)"
    }


    fun entrenar() {
        println("Entrenador: Vamos a entrenar")
    }

    override fun saludar() {
        println("Entrenador: Hola, soy $nombre y tengo $edad años y tengo $experiencia años de experiencia")
    }
}