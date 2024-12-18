package dev.joseluisgs.models.banda.sealed

class BajistaB(
    nombre: String
) : MusicoSealed(nombre) {

    override fun tocar() {
        println("Tocando bajo")
    }

    fun afinar() {
        println("Afinando")
    }
}