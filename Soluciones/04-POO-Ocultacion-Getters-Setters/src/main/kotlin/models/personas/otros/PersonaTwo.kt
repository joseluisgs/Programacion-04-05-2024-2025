package dev.joseluisgs.models

// Definiendo una clase con getters y setters
class PersonaTwo(
    var nombre: String,
    var apellidos: String,
    experiencia: Int
) {
    var experiencia: Int = 0
        set(value) {
            field = if (experiencia < 0) 0 else experiencia
        }

    init {
        this.experiencia = experiencia //if (experiencia < 0) 0 else experiencia
    }
}