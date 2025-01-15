package dev.joseluisgs.models.herencia

abstract class Coche(
    val marca: String,
    val modelo: String,
    val matricula: String
) {

    abstract fun arrancar()
    abstract fun parar()
}