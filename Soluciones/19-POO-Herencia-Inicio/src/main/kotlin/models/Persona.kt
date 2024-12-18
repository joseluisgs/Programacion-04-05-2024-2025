package dev.joseluisgs.models

open class Persona(var nombre: String, var edad: Int) {
    var curso: String = "DAW"

    open fun saludar(): String {
        return "Hola, soy $nombre y tengo $edad años y estoy en $curso"
    }

    fun saltar(): String {
        return "Estoy saltando"
    }

    override fun toString(): String {
        return "Persona(nombre='$nombre', edad=$edad, curso='$curso')"
    }
}