package dev.joseluisgs.models

class Portero(
    nombre: String,
    edad: Int,
    dorsal: Int,
    val paradas: Int,
) : Jugador(
    nombre, edad, dorsal
) {
    override fun toString(): String {
        return "Portero(nombre='$nombre', edad=$edad, dorsal=$dorsal, paradas=$paradas)"
    }


    fun parar() {
        println("Portero: Vamos a parar")
    }

    override fun entrenar(nivelEsfuerzo: Int) {
        println("Portero: Vamos a entrenar con un nivel de esfuerzo de $nivelEsfuerzo")
    }

    override fun saludar() {
        println("Portero: Hola, soy $nombre y tengo $edad años y tengo $paradas paradas")
    }
}