package dev.joseluisgs.models

abstract class ACantante {
    val experiencia: Int = 5

    open fun saludar() {
        println("Hola, soy un cantante abstracto")
    }

    abstract fun cantar()
}