package dev.joseluisgs.herencia

abstract class Persona(
    val id: Int,
    val nombre: String,
) {

    init {
        println("Creando persona $nombre")
    }

    fun presentarse() {
        println("Hola, soy $nombre")
    }

    open fun saludar() {
        println("Hola soy una persona")
    }

    override fun toString(): String {
        return "Persona(id=$id, nombre='$nombre')"
    }
}