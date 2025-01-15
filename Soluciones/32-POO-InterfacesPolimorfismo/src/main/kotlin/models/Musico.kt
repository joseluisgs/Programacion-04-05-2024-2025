package dev.joseluisgs.models

abstract class Musico(nombre: String) : Persona(nombre), Interpretador {
    open fun tocar() {
        println("Hola, soy Musico $nombre y estoy tocando")
    }

    override fun saluda() {
        println("Hola, soy Musico $nombre")
    }

    override fun interpretar() {
        println("Hola, soy Musico $nombre y estoy interpretando")
    }
}