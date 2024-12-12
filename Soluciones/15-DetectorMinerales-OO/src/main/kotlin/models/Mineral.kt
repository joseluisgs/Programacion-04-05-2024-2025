package models

class Mineral(var cantidad: Int) {
    override fun toString(): String {
        return cantidad.toString().padStart(2, '0')
    }
}