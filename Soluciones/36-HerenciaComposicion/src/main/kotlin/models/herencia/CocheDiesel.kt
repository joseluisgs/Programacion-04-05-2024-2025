package dev.joseluisgs.models.herencia

class CocheDiesel(
    marca: String,
    modelo: String,
    matricula: String,
) : Coche(
    marca, modelo, matricula
) {
    override fun arrancar() {
        println("Arrancando coche de diesel")
    }

    override fun parar() {
        println("Parando coche de diesel")
    }

    fun repostar() {
        println("Repostando coche de diesel")
    }
}