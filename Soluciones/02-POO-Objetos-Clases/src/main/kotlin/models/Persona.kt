package models

class Persona {
    // Definimos el estado de los objetos
    // Con las propiedades de la clase
    var nombre: String = ""
    var edad: Int = 0

    // Comportamiento de los objetos
    // Con los métodos de la clase
    fun saludar() {
        println("Hola, soy $nombre")
    }

    fun despedirse() {
        println("Adiós, soy $nombre")
    }

    fun esMayorDeEdad(): Boolean {
        return edad >= 18
    }

    fun comer(hamburguesa: Hamburguesa) {
        println("Estoy comiendo una hamburguesa")
        println("Hamburguesa: ${hamburguesa.nombre}")
        println("Y me ha costado ${hamburguesa.precio}€")
    }

}