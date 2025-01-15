package dev.joseluisgs.models

class CantanteC : ACantante(), ICantante {

    override fun cantar() {
        println("Canto como un cantante con herencia e interface")
    }

    override fun saludar() {
        super<ACantante>.saludar()
        super<ICantante>.saludar()
        println("Hola, soy un cantante completo")
    }


}