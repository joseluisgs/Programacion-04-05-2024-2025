package dev.joseluisgs.generalizacion

class Estudiante(
    val id: Int,
    val nombre: String,
    val calificacion: Double,
) {
    fun presentarse() {
        println("Hola, soy $nombre")
    }

    fun estudiar() {
        println("Estoy estudiando")
    }
}