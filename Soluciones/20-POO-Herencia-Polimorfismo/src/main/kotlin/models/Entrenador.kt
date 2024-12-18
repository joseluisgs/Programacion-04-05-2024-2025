package dev.joseluisgs.models

class Entrenador(nombre: String, edad: Int, val añosExperiencia: Int) : Persona(nombre, edad) {
    override fun toString(): String {
        return "Entrenador(nombre='$nombre', edad=$edad, añosExperiencia=$añosExperiencia)"
    }

    fun entrenar() {
        println("Entrenador: Vamos a entrenar")
    }
}