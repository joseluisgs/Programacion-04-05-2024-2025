package dev.joseluisgs.models.bien

interface Mamifero {
    fun amamantar()

    fun dormir() {
        println("El mamífero va a dormir")
    }
}

// Sabes la diferencia entre una interfaz y una clase abstracta:
/*
abstract class MamiferoAbstract {
    abstract fun amamantar()

    fun dormir() {
        println("El mamífero va a dormir")
    }
}
 */