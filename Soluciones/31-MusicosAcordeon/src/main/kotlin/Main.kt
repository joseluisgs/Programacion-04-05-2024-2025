package dev.joseluisgs

import dev.joseluisgs.controllers.GestorMusicos
import dev.joseluisgs.factories.MusicFactory
import dev.joseluisgs.models.Musico

fun main() {
    val bajista = Musico.Bajista("Flea", "Fender")
    bajista.tocar()
    bajista.llevarRitmo()
    println(bajista)

    val guitarrista = Musico.Guitarrista("Slash", "Gibson")
    guitarrista.tocar()
    guitarrista.hacerSolo()
    println(guitarrista)

    val cantante = Musico.Cantante("Axl Rose", "Shure")
    cantante.tocar()
    cantante.cantar()
    cantante.tocar()
    println(cantante)

    tocarConElGrupo(bajista)

    val musico = MusicFactory.random()
    println("Hola, soy $musico")
    println(musico)

    val gestorMusicos = GestorMusicos(10)

    repeat(30) {
        gestorMusicos.addMusico(MusicFactory.random())
    }
    println(gestorMusicos)

    repeat(20) {
        gestorMusicos.deleteMusico((10..30).random())
    }
    println(gestorMusicos)

    repeat(30) {
        gestorMusicos.addMusico(MusicFactory.random())
    }
    println(gestorMusicos)

    repeat(20) {
        gestorMusicos.deleteMusico((10..30).random())
    }
    println(gestorMusicos)


}

fun tocarConElGrupo(musico: Musico) {
    musico.tocar()
    when (musico) {
        is Musico.Bajista -> musico.llevarRitmo()
        is Musico.Guitarrista -> musico.hacerSolo()
        is Musico.Cantante -> musico.cantar()
    }
}