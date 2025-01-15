package dev.joseluisgs.models

class CafeteraCapsulasConLeche : ICalentador, ICapsulas, ILeche {
    override fun calentar() {
        println("Calentando")
    }

    override fun enfriar() {
        println("Enfriando")
    }

    override fun insertarCapsula() {
        println("Insertando capsula")
    }

    override fun expulsarCapsula() {
        println("Expulsando capsula")
    }

    override fun calentarLeche() {
        println("Calentando leche")
    }

    override fun emulsionarLeche() {
        println("Emulsionando leche")
    }
}