package dev.joseluisgs.models.mal

class OrnitorrincoMal : AnimalRaroMalDiseñadoAcoplado("Ornitorrinco") {
    override fun makeSound() {
        println("Cua cua")
    }

    override fun amamantar() {
        println("El ornitorrinco amamanta")
    }

    override fun ponerHuevos() {
        println("El ornitorrinco pone huevos")
    }
}