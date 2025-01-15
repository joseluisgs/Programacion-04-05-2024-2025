package dev.joseluisgs.models

class CafeteraCapsulas : ICafeteraCapsulas {
    override fun prepararCafetera() {
        println("Preparando cafetera de capsulas")
    }

    override fun limpiarCafetera() {
        println("Limpiando cafetera de capsulas")
    }

    override fun calentar() {
        println("Calentando cafetera de capsulas")
    }

    override fun enfriar() {
        println("Enfriando cafetera de capsulas")
    }

    override fun insertarCapsula() {
        println("Insertando capsula en cafetera de capsulas")
    }

    override fun expulsarCapsula() {
        println("Expulsando capsula en cafetera de capsulas")
    }
}