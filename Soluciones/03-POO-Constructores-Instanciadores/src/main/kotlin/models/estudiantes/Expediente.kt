package models.estudiantes

class Expediente(
    // Defino parte el estado de la clase dentro de la función constructora
    var grupo: String = "DAW",
    var curso: Int = 1,
    var nota: Double = 0.0,
) {
    fun mostrar() {
        println("Grupo: $grupo")
        println("Curso: $curso")
        println("Nota: $nota")
    }

    fun isAprobado(): Boolean {
        return nota >= 5.0
    }
}