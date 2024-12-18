package dev.joseluisgs.models

class Jugadora(
    nombre: String,
    edad: Int,
    val dorsal: Int,
    val numeroConvocatorias: Int = 0,
    val posicion: Posicion = Posicion.DEFENSA
) : Persona(nombre, edad) {

    fun jugar() {
        println("Jugadora: Vamos a jugar")
    }

    fun entrenar() {
        println("Jugadora: Vamos a entrenar")
    }

    override fun presentarse() {
        println("Jugadora: Hola, soy $nombre y tengo $edad años y mi dorsal es $dorsal")
    }

    enum class Posicion {
        PORTERA, DEFENSA, CENTROCAMPISTA, DELANTERA
    }
}
