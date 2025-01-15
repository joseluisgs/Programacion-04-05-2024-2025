package dev.joseluisgs.models.ornitorrinco

class Conejo : Animal(), Mamifero {
    override fun makeSound() {
        println("Conejo: Hago sonidos de conejo")
    }

    override fun amamantar(intensidad: Int): String {
        return "Conejo: Amamantando con intensidad $intensidad"
    }
}