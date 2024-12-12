package models

class Posicion private constructor(var fila: Int, var columna: Int) {

    fun getNuevaPosicionFrom(direccion: Direccion) {
        val nuevaFila = fila + direccion.fila
        val nuevaColumna = columna + direccion.columna
        fila = nuevaFila
        this.columna = nuevaColumna
    }

    companion object {
        fun getInitial(size: Int): Posicion {
            val posicionFila = (0..<size).random()
            val posicionColumna = (0..<size).random()
            return Posicion(posicionFila, posicionColumna)
        }
    }

    override fun toString(): String {
        return "Posicion Actual: f: ${this.fila + 1}, c: ${this.columna + 1}"
    }
}