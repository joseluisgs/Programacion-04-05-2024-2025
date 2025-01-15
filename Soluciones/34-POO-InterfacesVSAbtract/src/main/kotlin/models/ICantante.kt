package dev.joseluisgs.models

interface ICantante {
    val experiencia: Int

    fun saludar() {
        println("Hola, soy un cantante interface")
    }

    fun cantar()
}