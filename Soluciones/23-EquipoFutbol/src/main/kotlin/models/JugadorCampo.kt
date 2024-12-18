package dev.joseluisgs.models

import java.time.LocalDate

abstract class JugadorCampo(
    id: Int = NEW_ID,
    nombre: String,
    fechaNacimiento: LocalDate,
    val dorsal: Int,
    val posicion: Posicion,
) : Persona(
    id, nombre, fechaNacimiento
) {
    enum class Posicion {
        PORTERO, DEFENSA, CENTROCAMPISTA, DELANTERO
    }

    override fun entrenar() {
        println("Entrenando como jugador de campo: $nombre")
    }

    open fun jugar() {
        println("Jugando como jugador de campo: $nombre")
    }

    fun hidratarse() {
        println("Hidratandose como jugador de campo: $nombre")
    }
}