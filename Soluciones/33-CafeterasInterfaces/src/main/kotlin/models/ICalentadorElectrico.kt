package dev.joseluisgs.models

interface ICalentadorElectrico {
    fun calentar()
    fun enfriar()

    fun experimento() {
        println("Esto es un experimento de ICalentadorElectrico")
    }
}