package dev.joseluisgs.models.herencia

class CocheElectrico(
    marca: String,
    modelo: String,
    matricula: String,
) : Coche(
    marca, modelo, matricula
) {
    override fun arrancar() {
        println("Arrancando coche eléctrico")
    }

    override fun parar() {
        println("Parando coche eléctrico")
    }

    fun cargarBateria() {
        println("Cargando batería de coche eléctrico")
    }
}