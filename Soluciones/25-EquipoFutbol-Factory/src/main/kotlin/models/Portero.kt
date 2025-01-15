package dev.joseluisgs.models

import java.time.LocalDate

class Portero(
    id: Int,
    nombre: String,
    fechaNacimiento: LocalDate,
    dorsal: Int,
) : JugadorCampo(
    id,
    nombre,
    fechaNacimiento,
    dorsal,
    Posicion.PORTERO
) {


    fun parar() {
        println("Parando como portero: $nombre")
    }

    override fun toString(): String {
        return "Portero(id=$id, nombre='$nombre', fechaNacimiento=$fechaNacimiento, dorsal=$dorsal, posicion=$posicion)"
    }
}