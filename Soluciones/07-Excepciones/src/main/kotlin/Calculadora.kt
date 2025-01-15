package dev.joseluisgs

/**
 * Clase que implementa una calculadora
 * @property memoria Memoria de la calculadora
 */
class Calculadora {
    var memoria: Int = 0

    /**
     * Suma dos números
     * @param a Primer número a sumar
     * @param b Segundo número a sumar
     * @return Resultado de la suma
     */
    fun sumar(a: Int, b: Int): Int {
        memoria = a + b
        return memoria
    }

    /**
     * Suma un número usando la memoria
     * @param a Número a sumar
     * @return Resultado de la suma
     */
    fun sumar(a: Int): Int {
        memoria += a
        return memoria
    }

    /**
     * Resta dos números
     * @param a Primer número a restar
     * @param b Segundo número a restar
     * @return Resultado de la resta
     */

    fun restar(a: Int, b: Int): Int {
        memoria = a - b
        return memoria
    }

    /**
     * Resta un número usando la memoria
     * @param a Número a restar
     * @return Resultado de la resta
     */
    fun restar(a: Int): Int {
        memoria -= a
        return memoria
    }

    /**
     * Multiplica dos números
     * @param a Primer número a multiplicar
     * @param b Segundo número a multiplicar
     * @return Resultado de la multiplicación
     */
    fun multiplicar(a: Int, b: Int): Int {
        memoria = a * b
        return memoria
    }

    /**
     * Multiplica un número usando la memoria
     * @param a Número a multiplicar
     * @return Resultado de la multiplicación
     */
    fun multiplicar(a: Int): Int {
        memoria *= a
        return memoria
    }

    /**
     * Divide dos números
     * @param a Dividendo
     * @param b Divisor
     * @return Resultado de la división
     * @throws IllegalArgumentException Si el divisor es 0
     */
    fun dividir(a: Int, b: Int): Int {
        if (b == 0) {
            throw IllegalArgumentException("No se puede dividir por el dividendo 0")
        }
        memoria = a / b
        return memoria
    }

    /**
     * Divide un número usando la memoria
     * @param a Divisor
     * @return Resultado de la división
     */
    fun dividir(a: Int): Int {
        if (a == 0) {
            throw IllegalArgumentException("No se puede dividir por el dividendo 0")
        }
        memoria /= a
        return memoria
    }

}