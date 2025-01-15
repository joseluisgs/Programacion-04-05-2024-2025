package dev.joseluisgs.models

class Estudiante(nombre: String, val curso: String = "DAW") : Persona(nombre), Interpretador {

    fun estudiar() {
        println("Estoy estudiando $curso")
    }

    override fun interpretar() {
        println("Hola, soy Estudiante $nombre y estoy interpretando")
    }


}