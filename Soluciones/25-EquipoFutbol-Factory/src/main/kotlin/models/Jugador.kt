package dev.joseluisgs.models

import java.time.LocalDate

class Jugador(
    id: Int,
    nombre: String,
    fechaNacimiento: LocalDate,
    dorsal: Int,
    posicion: Posicion
) : JugadorCampo(
    id,
    nombre,
    fechaNacimiento,
    dorsal,
    posicion
) {


    override fun jugar() {
        super.jugar()
        println("corriendo ademas como jugador")
    }

    override fun entrenar() {
        println("Entrenando como jugador: $nombre")
    }

    fun chutar() {
        println("Chutando como jugador: $nombre")
    }

    override fun toString(): String {
        return "Jugador(id=$id, nombre='$nombre', fechaNacimiento=$fechaNacimiento, dorsal=$dorsal, posicion=$posicion)"
    }

}
