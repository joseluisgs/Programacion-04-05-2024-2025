package dev.joseluisgs.models.bien

abstract class Animal(val name: String) {
    abstract fun makeSound() // estas obligado a implementarla en clases hijas

    fun eat() {
        println("Animal va a comer")
    }
}