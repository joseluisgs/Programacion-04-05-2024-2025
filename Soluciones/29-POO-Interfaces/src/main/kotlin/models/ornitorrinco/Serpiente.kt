package dev.joseluisgs.models.ornitorrinco

class Serpiente : Animal(), Oviparo {
    override fun makeSound() {
        println("Serpiente: Shhhh")
    }

    override fun ponerHuevos(cantidad: Int) {
        println("Serpiente Poniendo $cantidad huevos")
    }
}