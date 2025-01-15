package dev.joseluisgs.models

class Portero(
    nombre: String,
    dorsal: Int
) : Jugador(nombre, RolPorteroImpl(dorsal)) {

    fun parar() {
        (rol as RolPortero).parar()
    }

    val role: RolPortero
        get() = rol as RolPortero

}