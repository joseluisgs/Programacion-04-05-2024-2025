package dev.joseluisgs.models

class Cantante(nombre: String) : Musico(nombre), Vocalista, Guitarrista {

    override fun saluda() {
        println("Hola, soy Cantante $nombre")
    }

    override fun tocar() {
        println("Hola, soy Cantante $nombre y estoy tocando")
    }

    override fun cantar() {
        println("Hola, soy Cantante $nombre y estoy cantando")
    }
}