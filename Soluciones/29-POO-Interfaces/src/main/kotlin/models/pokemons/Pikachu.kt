package dev.joseluisgs.models.pokemons

class Pikachu : Pokemon("Pikachu", 100), ElectricoEspecial {
    override fun attack(): String = "Ataque eléctrico"
    override fun defend(): String = "Defensa eléctrica"

    override fun impacTrueno() {
        println("Impacto trueno")
    }

    override fun rayo() {
        println("Rayo")
    }
}