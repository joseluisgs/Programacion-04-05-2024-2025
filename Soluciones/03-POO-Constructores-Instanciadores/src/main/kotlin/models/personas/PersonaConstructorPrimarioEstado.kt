package models.personas

class PersonaConstructorPrimarioEstado(
    // Defino parte el estado de la clase dentro de la función constructora
    // Ponemos lo que nos interesa que sea obligatorio para crear una instancia
    var nombre: String = "",
    var edad: Int = 0,
) {
    // Rest del Estado
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