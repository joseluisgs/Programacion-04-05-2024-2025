package dev.joseluisgs.herencia

class Estudiante(
    id: Int,
    nombre: String,
    val calificacion: Double,
) : Persona(id, nombre) {

    init {
        println("Creando estudiante $nombre")
    }

    fun estudiar() {
        println("Estoy estudiando")
    }

    override fun toString(): String {
        return "Estudiante(id=$id, nombre='$nombre', calificacion=$calificacion)"
    }
}