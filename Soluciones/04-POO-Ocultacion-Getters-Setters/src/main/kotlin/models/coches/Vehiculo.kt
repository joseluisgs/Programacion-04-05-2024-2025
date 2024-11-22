package models.coches

class Vehiculo(
    val matricula: String,
    val marca: String,
    val modelo: String,
) {
    fun mostrar() {
        println("Matricula: $matricula, Marca: $marca, Modelo: $modelo")
    }
}
