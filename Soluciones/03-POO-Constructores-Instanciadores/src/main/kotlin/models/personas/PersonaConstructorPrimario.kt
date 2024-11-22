package models.personas

class PersonaConstructorPrimario(
    // parametros de la función constructora
    var tuNombre: String = "",
    var tuEdad: Int = 0,
) {
    // Estado
    var nombre: String = tuNombre
    var edad: Int = tuEdad
    var genero: Char = 'M'

    // Comportamiento
    fun saludar() {
        println("Hola, soy $nombre")
    }

    fun despedirse() {
        println("Adiós, soy $nombre")
    }

    fun isMayorEdad(): Boolean {
        return edad >= 18
    }

    fun cambiarGenero(nuevoGenero: Char) {
        genero = nuevoGenero
    }
}