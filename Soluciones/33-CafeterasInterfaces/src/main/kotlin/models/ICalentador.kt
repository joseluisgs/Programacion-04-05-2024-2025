package dev.joseluisgs.models

interface ICalentador {
    fun calentar()
    fun enfriar()

    fun experimento() {
        println("Esto es un experimento de ICalentador")
    }

    fun otraCosa() {
        println("Esto es otra cosa de ICalentador")
    }
}