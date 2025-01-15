package models.personas

import org.lighthousegames.logging.logging

private val logger = logging()

class PersonaConstructorSecundario(
    // Defino parte el estado de la clase dentro de la función constructora
    // Ponemos lo que nos interesa que sea obligatorio para crear una instancia
    var nombre: String = "",
    var edad: Int = 0,
) {
    // Rest del Estado
    var genero: Char = 'M'

    // Constructor secundario
    constructor(nombre: String = "", edad: Int = 0, genero: Char = 'F') : this(nombre, edad) {
        logger.debug { "Constructor secundario" }
        this.genero = genero
    }

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

    fun cambiarGenero(genero: Char) {
        this.genero = genero
    }
}