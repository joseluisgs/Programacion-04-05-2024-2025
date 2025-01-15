package dev.joseluisgs.models

import java.time.LocalDate

class Entrenador(
    id: Int = NEW_ID,
    nombre: String,
    fechaNacimiento: LocalDate,
    val especialidad: String,
    val experiencia: Int = 0
) : Persona(
    id, nombre, fechaNacimiento
) {
    override fun entrenar() {
        super.entrenar()
        println("Entrenando como entrenador: $nombre")
    }

    override fun toString(): String {
        return "Entrenador(id=$id, nombre='$nombre', fechaNacimiento=$fechaNacimiento, especialidad='$especialidad', experiencia=$experiencia)"
    }
}