package dev.joseluisgs.models.pokemons

interface Terrestre {
    val intensidad: Int

    fun terremoto()

    fun arenaMovediza() {
        println("Arena movediza de intensidad $intensidad")
    }
}