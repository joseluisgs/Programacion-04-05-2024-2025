package models.estudiantes

class Estudiante(
    var nombre: String,
    var edad: Int,
    var expediente: Expediente
) {

    fun saludar() {
        println("Hola $nombre")
    }

    fun despedirse() {
        println("Adios $nombre")
    }

    fun mostrar() {
        println("Nombre: $nombre")
        println("Edad: $edad")
        println("Expediente:")
        expediente.mostrar()
    }

    fun isAprobado(): Boolean {
        return expediente.isAprobado()
    }
}