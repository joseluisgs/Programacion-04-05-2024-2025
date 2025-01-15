package models.persona

import java.time.LocalDateTime

class Persona(
    var nombre: String,
    var edad: Int,
    private val createdAt: LocalDateTime = LocalDateTime.now()
) {
    fun presentarse() {
        println("Hola, mi nombre es $nombre y tengo $edad años y nací el $createdAt")
    }

    // El metodo equals es un metodo especial
    // Nos permite comparar objetos
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Persona) return false

        if (nombre != other.nombre) return false
        if (edad != other.edad) return false

        // O simplemente
        // if (this.hashCode() != other.hashCode()) return false

        return true
    }

    override fun hashCode(): Int {
        var result = nombre.hashCode()
        result = 31 * result + edad
        return result
    }

    override fun toString(): String {
        return "Persona(nombre='$nombre', edad=$edad, createdAt=$createdAt)"
    }


}