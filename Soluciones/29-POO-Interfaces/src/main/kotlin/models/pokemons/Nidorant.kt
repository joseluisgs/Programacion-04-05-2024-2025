package dev.joseluisgs.models.pokemons

class Nidorant(override val intensidad: Int) : Pokemon("Nidorant", 100), Terrestre, Arenizo {
    override fun terremoto() {
        TODO("Not yet implemented")
    }

    override fun attack(): String {
        TODO("Not yet implemented")
    }

    override fun defend(): String {
        TODO("Not yet implemented")
    }

    override fun arenaMovediza() {
        super<Terrestre>.arenaMovediza()
        super<Arenizo>.arenaMovediza()
    }


}