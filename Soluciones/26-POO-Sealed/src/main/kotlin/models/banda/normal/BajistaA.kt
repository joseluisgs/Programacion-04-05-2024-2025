package dev.joseluisgs.models.banda.normal

class BajistaA(
    nombre: String
) : MusicoAbstract(nombre) {
    override fun tocar() {
        println("Tocando bajo")
    }

    fun afinar() {
        println("Afinando")
    }
}