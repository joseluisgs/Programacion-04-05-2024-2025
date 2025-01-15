package dev.joseluisgs.controllers

import dev.joseluisgs.models.Musico

class GestorMusicos(val defaultSize: Int = 10) {
    private var musicos: Array<Musico?> = arrayOfNulls<Musico>(defaultSize)


    override fun toString(): String {
        ordenarMusicos()
        return "GestorMusicos(musicos=${musicos.contentToString()})"
    }


    fun addMusico(musico: Musico) {
        println("Añadiendo el musico $musico")
        var index = buscarPrimerNull()
        if (index != -1) {
            musicos[index] = musico
        } else {
            // Redimensionamos el array e insertamos
            index = musicos.size
            maximizarArray()
            musicos[index] = musico

        }
    }

    fun deleteMusico(id: Int) {
        println("Borrando el musico con id $id")
        var index = buscarMusicoPorId(id)
        if (index != -1) {
            musicos[index] = null
        }
        // contar el numero de nulls
        val nulls = contarNulls()
        if (nulls > defaultSize) {
            // Redimensionamos el array
            minimizarArray()
        }
    }

    private fun minimizarArray() {
        println("Minimizando el array")
        val nuevoArray = arrayOfNulls<Musico>(musicos.size - defaultSize)
        var nuevoIndex = 0
        for (i in musicos.indices) {
            if (musicos[i] != null) {
                nuevoArray[nuevoIndex] = musicos[i]
                nuevoIndex++
            }
        }
        // Cambiamos el array
        musicos = nuevoArray
    }

    private fun contarNulls(): Int {
        var nulls = 0
        for (i in musicos.indices) {
            if (musicos[i] == null) {
                nulls++
            }
        }
        return nulls
    }

    private fun buscarMusicoPorId(id: Int): Int {
        for (i in musicos.indices) {
            if ((musicos[i]?.id ?: Int.MAX_VALUE) == id) {
                return i
            }
        }
        return -1
    }

    fun ordenarMusicos() {
        println("Ordenando los musicos")
        // Burbuja por id
        for (i in 0 until musicos.size - 1) {
            for (j in 0 until musicos.size - i - 1) {
                // Comprueba si alguno de los dos elementos a comparar es nulo o si el id del primero es mayor que el del segundo
                if ((musicos[j]?.id ?: Int.MAX_VALUE) > (musicos[j + 1]?.id ?: Int.MAX_VALUE)) {
                    // Intercambia elementos
                    val temp = musicos[j]
                    musicos[j] = musicos[j + 1]
                    musicos[j + 1] = temp
                }
            }
        }
    }

    private fun maximizarArray() {
        println("Maximizando el array")
        val nuevoArray = arrayOfNulls<Musico>(musicos.size + defaultSize)
        for (i in musicos.indices) {
            nuevoArray[i] = musicos[i]
        }
        musicos = nuevoArray
    }

    fun buscarPrimerNull(): Int {
        for (i in musicos.indices) {
            if (musicos[i] == null) {
                return i
            }
        }
        return -1
    }
}