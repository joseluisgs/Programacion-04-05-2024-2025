package dev.joseluisgs.models.composicion

class MotorElectrico : IMotorElectrico {
    override fun arrancar() {
        println("Arrancando motor eléctrico")
    }

    override fun parar() {
        println("Parando motor eléctrico")
    }

    override fun cargarBateria() {
        println("Cargando batería")
    }
}