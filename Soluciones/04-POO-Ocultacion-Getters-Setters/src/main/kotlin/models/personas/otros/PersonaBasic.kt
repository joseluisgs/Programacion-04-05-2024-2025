package dev.joseluisgs.models

// Definiendo una clase con getters y setters
class PersonaBasic {
    var nombre: String = ""
    var apellidos: String = ""
    private var _energia: Int = 0

    var experiencia: Int = 0
        set(value) {
            field = if (value < 0) {
                0
            } else {
                value
            }
        }

    var energia: Int
        get() = _energia
        set(value) {
            when {
                value < 0 -> _energia = 0
                value > 1000 -> _energia = 1000

            }
        }

    val nombreCompleto: String
        get() = "$nombre $apellidos"

    fun programar(lenguaje: String) {
        println("Programando en $lenguaje")
    }

    private fun dormir() {
        println("Durmiendo...")
    }

    /*// Getter
    fun getExperiencia(): Int {
        return experiencia
    }

    // Setter
    fun setExperiencia(experiencia: Int) {
        if (experiencia < 0) {
            this.experiencia = 0
        } else {
            this.experiencia = experiencia
        }
    }*/
}