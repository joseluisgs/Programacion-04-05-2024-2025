package dev.joseluisgs.models.ornitorrinco

class Ornitorrinco : Animal(), Mamifero, Oviparo {
    override fun makeSound() {
        println("Ornitorrinco Cua cua cua")
    }

    override fun amamantar(intensidad: Int): String {
        return "Ornitorrinco Amamantando con intensidad $intensidad"
    }

    override fun ponerHuevos(cantidad: Int) {
        println("Ornitorrinco Poniendo $cantidad huevos")
    }
}