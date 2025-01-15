package dev.joseluisgs.models.composicion

class Coche(
    val marca: String,
    val modelo: String,
    val matricula: String,
    var motor: IMotor
) {
    fun arrancar() {
        motor.arrancar()
    }

    fun parar() {
        motor.parar()
    }
}