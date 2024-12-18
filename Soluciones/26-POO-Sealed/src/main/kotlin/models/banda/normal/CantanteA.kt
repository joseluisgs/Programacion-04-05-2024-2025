package dev.joseluisgs.models.banda.normal

class CantanteA(
    nombre: String
) : MusicoAbstract(nombre) {
    override fun tocar() {
        println("Tocando cantante")
    }

    fun cantar() {
        println("Cantando")
    }
}