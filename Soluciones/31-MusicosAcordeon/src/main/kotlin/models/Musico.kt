package dev.joseluisgs.models

import java.time.LocalDateTime

sealed class Musico(val nombre: String) {
    val id = ++idKey
    val createdAt = LocalDateTime.now()
    abstract fun tocar()

    companion object {
        private var idKey = 0
    }


    class Bajista(nombre: String, val bajo: String) : Musico(nombre) {
        override fun tocar() {
            println("Tocando el bajo $bajo")
        }

        fun llevarRitmo() {
            println("Llevando ritmo con el bajo $bajo")
        }

        override fun toString(): String {
            return "Bajista(nombre='$nombre', bajo='$bajo', id=$id, createdAt=$createdAt)"
        }
    }

    class Guitarrista(nombre: String, val guitarra: String) : Musico(nombre) {
        override fun tocar() {
            println("Tocando la guitarra $guitarra")
        }

        fun hacerSolo() {
            println("Haciendo solo con la guitarra $guitarra")
        }

        override fun toString(): String {
            return "Guitarrista(nombre='$nombre', guitarra='$guitarra', id=$id, createdAt=$createdAt)"
        }
    }

    class Cantante(nombre: String, val microfono: String) : Musico(nombre) {
        override fun tocar() {
            println("Tocando el microfono $microfono")
        }

        fun cantar() {
            println("Cantando con el microfono $microfono")
        }

        override fun toString(): String {
            return "Cantante(nombre='$nombre', microfono='$microfono', id=$id, createdAt=$createdAt)"
        }
    }
}