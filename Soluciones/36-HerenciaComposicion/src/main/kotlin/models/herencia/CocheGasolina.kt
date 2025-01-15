package dev.joseluisgs.models.herencia

class CocheGasolina(
    marca: String,
    modelo: String,
    matricula: String,

    ) : Coche(
    marca, modelo, matricula
) {
    override fun arrancar() {
        println("Arrancando coche de gasolina")
    }

    override fun parar() {
        println("Parando coche de gasolina")
    }

    fun repostar() {
        println("Repostando coche de gasolina")
    }
}