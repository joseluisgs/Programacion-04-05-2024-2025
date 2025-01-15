package dev.joseluisgs.models.mal

class SerpienteMal : AnimalRaroMalDiseñadoAcoplado("Serpiente") {
    override fun makeSound() {
        println("Sssss")
    }

    override fun amamantar() {
        throw UnsupportedOperationException("Las serpientes no amamantan")
    }

    override fun ponerHuevos() {
        println("La serpiente pone huevos")
    }
}