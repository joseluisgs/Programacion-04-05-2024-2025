package dev.joseluisgs.models.bien

class Ornitorrinco(
    name: String,
    override val numeroHuevos: Int
) : Animal(name), Mamifero, Oviparo {
    override fun makeSound() {
        println("El ornitorrínco Hace un sonido raro")
    }

    override fun amamantar() {
        println("El ornitorrinco está amamantando")
    }

    override fun ponerHuevos() {
        println("El ornitorrinco pone huevos")
    }
}