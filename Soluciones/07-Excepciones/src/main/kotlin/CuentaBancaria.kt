package dev.joseluisgs

class CuentaBancaria {
    private var saldo: Double = 0.0

    fun depositar(cantidad: Double) {
        if (cantidad <= 0) {
            throw IllegalArgumentException("La cantidad a depositar debe ser mayor que 0")
        }
        saldo += cantidad
    }

    fun retirar(cantidad: Double) {
        if (cantidad <= 0) {
            throw IllegalArgumentException("La cantidad a retirar debe ser mayor que 0")
        }
        /*if (cantidad > saldo) {
            throw IllegalStateException("No hay fondos suficientes para retirar")
        }*/
        saldo -= cantidad
        // Avisamos si hay numeros rojos mayor a 1000
        if (saldo < -1000) {
            throw IllegalStateException("Saldo en números rojos mayor a 1000")
        }
        if (saldo == 666.66) {
            throw IllegalStateException("Saldo del diablo")
        }
    }
}