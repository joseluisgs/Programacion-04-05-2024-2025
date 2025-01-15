package dev.joseluisgs

import dev.joseluisgs.models.ornitorrinco.Conejo
import dev.joseluisgs.models.ornitorrinco.Ornitorrinco
import dev.joseluisgs.models.ornitorrinco.Serpiente
import dev.joseluisgs.models.pokemons.Nidorant
import dev.joseluisgs.models.pokemons.Onix
import dev.joseluisgs.models.pokemons.Pikachu
import dev.joseluisgs.models.pokemons.SuperKuki

fun main() {
    println("Hola Interfaces!")
    val ornitorrinco = Ornitorrinco()
    ornitorrinco.makeSound()
    println(ornitorrinco.amamantar(10))
    ornitorrinco.ponerHuevos(10)

    val serpiente = Serpiente()
    serpiente.makeSound()
    serpiente.ponerHuevos(10)

    val conejo = Conejo()
    conejo.makeSound()
    println(conejo.amamantar(10))

    val onix = Onix()
    onix.attack()
    onix.defend()
    onix.terremoto()
    onix.arenaMovediza()

    val pikachu = Pikachu()
    pikachu.attack()
    pikachu.defend()
    pikachu.impacTrueno()
    pikachu.rayo()

    val superKuki = SuperKuki()
    superKuki.attack()
    superKuki.defend()
    superKuki.impacTrueno()
    superKuki.terremoto()

    val nidorant = Nidorant(10)
    nidorant.attack()
    nidorant.defend()
    nidorant.terremoto()
    nidorant.arenaMovediza()




}