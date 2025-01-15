package dev.joseluisgs.models.pokemons

class Onix(
    val potenciaSalto: Int = 20,
    override val intensidad: Int = 10
) : Pokemon("Onix", 100), Terrestre {
    override fun attack(): String {
        return "Onix: Terremoto con intensidad $intensidad"
    }

    override fun defend(): String {
        return "Onix: Defendiendo con potencia de salto $potenciaSalto"
    }

    override fun terremoto() {
        println(this.attack())
    }

}