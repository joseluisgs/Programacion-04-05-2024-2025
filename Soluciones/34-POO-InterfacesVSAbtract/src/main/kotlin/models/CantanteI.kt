package dev.joseluisgs.models

class CantanteI : ICantante {
    override val experiencia: Int = 5
    override fun cantar() {
        println("Canto como un cantante con interface")
    }

    /*override fun saludar() {
        super.saludar()
        println("Hola, soy un cantante abstracto")
    }*/
}