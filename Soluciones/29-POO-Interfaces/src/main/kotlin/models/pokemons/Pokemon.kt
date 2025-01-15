package dev.joseluisgs.models.pokemons

abstract class Pokemon(
    val name: String,
    val energy: Int,
) {
    abstract fun attack(): String
    abstract fun defend(): String
}