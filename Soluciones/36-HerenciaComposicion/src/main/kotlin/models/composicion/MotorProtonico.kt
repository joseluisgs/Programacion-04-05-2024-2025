package dev.joseluisgs.models.composicion

class MotorProtonico : IMotorProtonico {
    override fun explosionar() {
        println("Explosionando... 3, 2, 1... 🤯")
    }

    override fun arrancar() {
        println("Arrancando motor protonico...")
    }

    override fun parar() {
        println("Parando motor protonico...")
    }
}