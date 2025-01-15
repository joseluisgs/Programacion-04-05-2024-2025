package dev.joseluisgs.models

class Alumno(nombre: String, edad: Int, var calificacion: Double) : Persona(nombre, edad) {
    val isAprobado: Boolean
        get() = calificacion >= 5.0

    fun presentar(): String {
        return "Hola, soy $nombre y tengo $edad años y estoy en $curso y mi calificación es $calificacion"
    }
}