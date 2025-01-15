package dev.joseluisgs.factories

import dev.joseluisgs.models.Musico

class MusicFactory {

    companion object {
        fun random(): Musico {
            val random = (0..2).random()
            val nombre = arrayOf("Flea", "Slash", "Axl Rose", "Kurt Cobain", "Eddie Vedder", "Dave Grohl").random()
            val instrumento = arrayOf("Fender", "Gibson", "Shure", "Yamaha", "Roland", "Pearl").random()
            return when (random) {
                0 -> Musico.Bajista(nombre, instrumento)
                1 -> Musico.Guitarrista(nombre, instrumento)
                else -> Musico.Cantante(nombre, instrumento)
            }
        }
    }
}