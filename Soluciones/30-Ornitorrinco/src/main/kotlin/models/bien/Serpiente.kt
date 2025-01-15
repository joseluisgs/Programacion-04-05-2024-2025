package dev.joseluisgs.models.bien

class Serpiente(nombre: String = "serpiente") : Animal(nombre), Oviparo {
    override val numeroHuevos: Int = 10

    override fun makeSound() {
        println("Sssss")
    }

    override fun ponerHuevos() {
        println("La serpiente pone huevos")
    }
}