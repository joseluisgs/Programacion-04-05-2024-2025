package dev.joseluisgs.models

open class Persona(
    val nombre: String,
    var rol: Rol
) {
    override fun toString(): String {
        return "Persona(nombre='$nombre', rol=$rol)"
    }
}