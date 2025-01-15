package dev.joseluisgs.models

abstract class Persona(val nombre: String) {
    open fun saluda() {
        println("Hola, soy Persona $nombre")
    }
}