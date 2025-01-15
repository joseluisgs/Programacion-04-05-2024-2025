package dev.joseluisgs

class Persona {
    var nombre: String = ""
        set(value) {
            if (value.isBlank()) {
                throw IllegalArgumentException("Nombre no puede ser vacío")
            }
            field = value
            if (value.contains(" ")) {
                throw IllegalStateException("Nombre no puede contener espacios")
            }
        }
    var edad: Int = 0
        set(value) {
            if (value < 0) {
                throw IllegalArgumentException("Edad no puede ser negativa")
            }
            field = value
        }

}