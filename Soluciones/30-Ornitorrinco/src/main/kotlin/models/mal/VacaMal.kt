package dev.joseluisgs.models.mal

class VacaMal : AnimalRaroMalDiseñadoAcoplado("Vaca") {
    override fun makeSound() {
        println("Mu")
    }

    override fun amamantar() {
        println("La vaca amamanta")
    }

    override fun ponerHuevos() {
        throw UnsupportedOperationException("Las vacas no ponen huevos")
    }

}