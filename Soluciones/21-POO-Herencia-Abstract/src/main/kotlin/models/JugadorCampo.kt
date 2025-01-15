package dev.joseluisgs.models

class JugadorCampo(
    nombre: String,
    edad: Int,
    dorsal: Int,
    val goles: Int,
) : Jugador(
    nombre, edad, dorsal
) {
    override fun toString(): String {
        return "JugadorCampo(nombre='$nombre', edad=$edad, dorsal=$dorsal, goles=$goles)"
    }


    fun marcar() {
        println("JugadorCampo: Vamos a marcar")
    }

    override fun entrenar(nivelEsfuerzo: Int) {
        println("JugadorCampo: Vamos a entrenar con un nivel de esfuerzo de $nivelEsfuerzo")
    }

    override fun saludar() {
        println("JugadorCampo: Hola, soy $nombre y tengo $edad años y tengo $goles goles")
    }
}


