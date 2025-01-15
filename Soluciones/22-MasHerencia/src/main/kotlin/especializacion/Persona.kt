package dev.joseluisgs.especializacion

class Persona(
    val id: Int,
    val nombre: String,
    val antiguedad: Int = 0,
    val calificacion: Double = 0.0,
    val tipo: TipoPersona
) {
    fun presentarse() {
        print("Hola, soy $nombre ")
        when (tipo) {
            TipoPersona.ESTUDIANTE -> println("tengo una calificación de $calificacion")
            TipoPersona.PROFESOR -> println("tengo $antiguedad años de experiencia")
        }
    }

    fun enseñar() {
        require(tipo == TipoPersona.PROFESOR) { "Solo los profesores pueden enseñar" }
        println("Estoy enseñando")
    }

    fun estudiar() {
        require(tipo == TipoPersona.ESTUDIANTE) { "Solo los estudiantes pueden estudiar" }
        println("Estoy estudiando")
    }

    enum class TipoPersona {
        ESTUDIANTE,
        PROFESOR,
    }


}