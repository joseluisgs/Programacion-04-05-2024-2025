package dev.joseluisgs.models.composicion

class MotorDiesel : IMotorCombustion {
    override fun arrancar() {
        println("Arrancando motor diesel")
    }

    override fun parar() {
        println("Parando motor diesel")
    }

    override fun repostar() {
        println("Repostando motor diesel")
    }
}