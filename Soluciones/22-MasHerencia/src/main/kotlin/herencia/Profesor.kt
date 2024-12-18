package dev.joseluisgs.herencia

class Profesor(
    id: Int,
    nombre: String,
    val antiguedad: Int,
) : Persona(id, nombre) {

    init {
        println("Creando profesor $nombre")
    }

    fun enseñar() {
        println("Estoy enseñando")
    }

    override fun saludar() {
        println("Hola soy un profesor")
    }

    override fun toString(): String {
        return "Profesor(id=$id, nombre='$nombre', antiguedad=$antiguedad)"
    }
}