package models

class Estudiante {
    var nombre: String = ""
    var edad: Int = 0
    var expediente: Expediente = Expediente()

    fun mostrar() {
        println("Nombre: $nombre")
        println("Edad: $edad")
        expediente.mostrar()
        if (isMayorDeEdad()) {
            println("Es mayor de edad")
        } else {
            println("Es menor de edad")
        }
        if (isAprobado()) {
            println("Está aprobado con: ${expediente.nota}")
        } else {
            println("Está suspenso: ${expediente.nota}")
        }
    }

    fun isMayorDeEdad(): Boolean {
        return edad >= 18
    }

    fun isAprobado(): Boolean {
        return expediente.nota >= 5
    }
}