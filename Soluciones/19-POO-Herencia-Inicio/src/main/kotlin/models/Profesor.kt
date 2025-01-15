package dev.joseluisgs.models

class Profesor(nombre: String, edad: Int, var asignatura: String) : Persona(nombre, edad) {
    fun darClase(): String {
        return "Hola, soy $nombre y tengo $edad años y doy $asignatura"
    }

    override fun saludar(): String {
        return "Hola, soy Profesor $nombre y tengo $edad años y doy $asignatura"
    }

    override fun toString(): String {
        return "Profesor(nombre='$nombre', edad=$edad, asignatura='$asignatura')"
    }
}