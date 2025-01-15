package dev.joseluisgs.models.pokemons

class SuperKuki : Pokemon("Super Kuki", 100), Terrestre, Electrico {
    override val intensidad: Int = 100

    override fun terremoto() {
        println("Terremoto de intensidad $intensidad")
    }


    override fun impacTrueno() {
        println("Impacto trueno de intensidad $intensidad")
    }

    override fun attack(): String {
        return "Ataque de Super Kuki"
    }

    override fun defend(): String {
        return "Defensa de Super Kuki"
    }
}