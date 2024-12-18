package dev.joseluisgs.models

import java.time.LocalDate

abstract class Persona(
    val id: Int = NEW_ID,
    val nombre: String,
    val fechaNacimiento: LocalDate = LocalDate.now(),
) {

    companion object {
        private var contadorPersonas = 0
        fun nextId(): Int {
            contadorPersonas++
            return contadorPersonas
        }

        const val NEW_ID = 0
    }

    open fun entrenar() {
        println("Entrenando como persona...")
    }
}