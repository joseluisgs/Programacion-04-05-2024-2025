package dev.joseluisgs.models.banda.normal

abstract class MusicoAbstract(
    val nombre: String
) {
    abstract fun tocar()

    fun presentar() {
        println("Hola soy $nombre")
    }
}