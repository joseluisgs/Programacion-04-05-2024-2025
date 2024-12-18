package dev.joseluisgs.generalizacion

class Profesor(
    val id: Int,
    val nombre: String,
    val antiguedad: Int,
) {
    fun presentarse() {
        println("Hola, soy $nombre y tengo $antiguedad años de experiencia")
    }

    fun enseñar() {
        println("Estoy enseñando")
    }
}