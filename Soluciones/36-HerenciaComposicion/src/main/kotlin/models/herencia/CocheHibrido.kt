package dev.joseluisgs.models.herencia

class CocheHibrido(
    marca: String,
    modelo: String,
    color: String,
) : Coche(marca, modelo, color) {
    override fun arrancar() {
        println("Arrancando coche híbrido")
    }

    override fun parar() {
        println("Parando coche híbrido")
    }

    fun cargarBateria() {
        println("Cargando batería de coche híbrido")
    }

    fun repostar() {
        println("Repostando coche híbrido")
    }
}