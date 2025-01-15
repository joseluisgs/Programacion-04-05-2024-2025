package dev.joseluisgs.models.mal

abstract class AnimalRaroMalDiseñadoAcoplado(val name: String) {
    abstract fun makeSound() // estas obligado a implementarla en clases hijas

    fun eat() {
        println("Animal va a comer")
    }

    abstract fun amamantar()
    abstract fun ponerHuevos()
}