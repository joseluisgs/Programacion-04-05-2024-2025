package dev.joseluisgs

import dev.joseluisgs.models.bien.*
import dev.joseluisgs.models.mal.VacaMal

fun main() {
    val ornitorrinco = Ornitorrinco("Perry", 2)
    ornitorrinco.eat() // Esto es por ser animal, pues no se ha implementado en Ornitorrinco
    ornitorrinco.makeSound() // Es de ornitorrinco obligado por ser Animal a implementar (abstract)
    ornitorrinco.amamantar() // Es de Mamifero y Ornitorrinco lo implementa
    ornitorrinco.ponerHuevos() // Es de Oviparo y Ornitorrinco lo implementa
    ornitorrinco.dormir() // Es de Mamifero y Ornitorrinco coge la implementación de Mamifero

    val vacaMal = VacaMal()
    //vacaMal.ponerHuevos()
    val vaca = Vaca()
    vaca.makeSound()
    vaca.amamantar()

    val serpiente = Serpiente()
    serpiente.makeSound()
    serpiente.ponerHuevos()

    // Las interfaces me sirven para tipar
    val animales: Array<Mamifero> = arrayOf(vaca, ornitorrinco)
    mamadores(vaca)
    mamadores(ornitorrinco)

    val cobra: Oviparo = Serpiente("Cobra")
    cobra.ponerHuevos()


}

fun mamadores(mamifero: Mamifero) {
    mamifero.amamantar()
}

fun analizadorCasosRaros(animal: Animal) {
    when (animal) {
        is Mamifero -> {
            animal.amamantar()
        }

        is Oviparo -> {
            animal.ponerHuevos()
        }

        else -> {
            animal.makeSound()
        }
    }
}