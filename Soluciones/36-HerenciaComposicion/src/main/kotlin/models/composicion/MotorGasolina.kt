package dev.joseluisgs.models.composicion

class MotorGasolina : IMotorCombustion {
    override fun arrancar() {
        println("Arrancando motor de gasolina")
    }

    override fun parar() {
        println("Parando motor de gasolina")
    }

    override fun repostar() {
        println("Repostando motor de gasolina")
    }
}