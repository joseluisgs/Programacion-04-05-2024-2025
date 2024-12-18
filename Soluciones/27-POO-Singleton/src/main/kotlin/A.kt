package dev.joseluisgs

class A {

    init {
        println("Creando instancia A")
        count++
    }

    override fun toString(): String {
        return "A: $count"
    }

    companion object {
        private var count = 0
    }
}