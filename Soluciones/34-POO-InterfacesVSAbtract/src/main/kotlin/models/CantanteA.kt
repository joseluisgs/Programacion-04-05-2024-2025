package dev.joseluisgs.models

class CantanteA : ACantante() {
    override fun cantar() {
        println("Canto como un cantante con herencia")
    }

    /*override fun saludar() {
        super.saludar()
        println("Hola, soy un cantante abstracto")
    }*/
}