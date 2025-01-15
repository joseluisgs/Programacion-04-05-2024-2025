package dev.joseluisgs.models

class CafeteraConLeche : ICafeteraConLeche {
    override fun hacerCafeConLeche() {
        println("Haciendo café con leche")
    }

    override fun calentar() {
        println("Calentando")
    }

    override fun enfriar() {
        println("Enfriando")
    }

    override fun calentarLeche() {
        println("Calentando leche")
    }

    override fun emulsionarLeche() {
        println("Emulsionando leche")
    }
}