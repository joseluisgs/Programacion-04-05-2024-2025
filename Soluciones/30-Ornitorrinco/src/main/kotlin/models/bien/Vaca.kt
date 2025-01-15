package dev.joseluisgs.models.bien

class Vaca : Animal("Vaca"), Mamifero {
    override fun makeSound() {
        println("Mu")
    }

    override fun amamantar() {
        println("La vaca amamanta")
    }
}