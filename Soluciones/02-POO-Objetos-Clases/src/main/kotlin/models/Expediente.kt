package models

class Expediente {
    var numero: Int = 0
    var email: String = ""
    var curso: String = ""
    var nota: Double = 0.0

    fun mostrar() {
        println("Número: $numero")
        println("Email: $email")
        println("Curso: $curso")
        println("Nota: $nota")
    }
}
