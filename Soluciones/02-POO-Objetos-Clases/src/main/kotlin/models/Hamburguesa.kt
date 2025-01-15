package models

class Hamburguesa {
    // Estado, propiedades
    var nombre: String = ""
    var precio: Double = 0.0
    var ingredientes: Array<String> = Array(10) { "" }

    // Comportamiento, métodos
    fun mostrar() {
        println("Hamburguesa $nombre")
        println("Precio: $precio")
        println("Ingredientes: ${imprimirIngredientes()}")
    }

    private fun imprimirIngredientes(): String {
        var ingredientesString = StringBuilder()
        for (ingrediente in ingredientes) {
            if (ingrediente != "") {
                ingredientesString.append("$ingrediente, ")
            }
        }
        return ingredientesString.toString()
    }

    fun agregarIngrediente(posicion: Int, ingrediente: String) {
        if (posicion < 1 || posicion > 10) {
            println("Posición incorrecta")
            return
        }
        ingredientes[posicion - 1] = ingrediente
    }
}