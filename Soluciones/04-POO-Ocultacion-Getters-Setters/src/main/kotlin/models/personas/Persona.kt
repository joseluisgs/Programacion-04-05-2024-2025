package models.personas

class Persona {
    var nombre: String = ""
    var edad: Int = 0

    fun mostrar() {
        println(nombre)
        println(edad)
    }
}