package dev.joseluisgs

/**
 * Clase que implementa una cuenta bancaria
 * @property saldo Saldo de la cuenta
 * @constructor Crea una cuenta bancaria con un saldo inicial
 */
class CuentaBancariaProKotlin(
    private var saldo: Double = 0.0
) {

    /**
     * Función para depositar dinero en la cuenta
     * @param cantidad Cantidad a depositar
     * @throws IllegalArgumentException Si la cantidad a depositar es menor o igual a 0
     */
    fun depositar(cantidad: Double) {
        require(cantidad > 0) { "La cantidad a depositar debe ser mayor que 0" }
        saldo += cantidad
    }

    /**
     * Función para retirar dinero de la cuenta
     * @param cantidad Cantidad a retirar
     * @throws IllegalArgumentException Si la cantidad a retirar es menor o igual a 0
     * @throws IllegalStateException Si nos quedamos en números rojos mayor a 1000
     * @throws IllegalStateException Si el saldo es 666.66
     */
    fun retirar(cantidad: Double) {
        require(cantidad > 0) { "La cantidad a retirar debe ser mayor que 0" }
        saldo -= cantidad
        // Avisamos si hay numeros rojos mayor a 1000
        check(saldo >= -1000) { "Saldo en números rojos mayor a 1000" }
        if (saldo == 666.66) {
            error("Saldo del diablo")
        }
    }

    fun getSaldo(): Double {
        return saldo
    }


    fun saldoAsEuro(): String {
        return "$saldo €"
    }

    override fun toString(): String {
        return "CuentaBancariaProKotlin(saldo=$saldo)"
    }
}