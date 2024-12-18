package dev.joseluisgs

class X private constructor() {

    init {
        println("Creando instancia X")
        count++
    }

    override fun toString(): String {
        return "X: $count"
    }

    companion object {
        private var count = 0
        private var instance: X? = null

        fun getInstance(): X {
            if (instance == null) {
                instance = X()
            }
            return instance!!
        }
    }
}