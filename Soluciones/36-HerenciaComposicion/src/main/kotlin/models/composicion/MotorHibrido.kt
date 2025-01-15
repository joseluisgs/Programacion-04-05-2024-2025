package dev.joseluisgs.models.composicion

class MotorHibrido : IMotorElectrico, IMotorCombustion {
    override fun arrancar() {
        println("Arrancando motor híbrido")
    }

    override fun parar() {
        println("Parando motor híbrido")
    }

    override fun cargarBateria() {
        println("Cargando batería del motor híbrido")
    }

    override fun repostar() {
        println("Repostando motor híbrido")
    }
}