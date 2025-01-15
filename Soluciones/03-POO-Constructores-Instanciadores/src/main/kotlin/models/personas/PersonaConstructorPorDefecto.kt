package models.personas

class PersonaConstructorPorDefecto {
    // Estado
    var nombre: String = ""
    var edad: Int = 0
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