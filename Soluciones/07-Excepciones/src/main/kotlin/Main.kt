package dev.joseluisgs

fun main() {
    //var i = leerEntero()
    //i = leerEnteroRegex()
    //i = leerEnteroException()


    val calculadora = Calculadora()
    println("Suma de 2 + 3 = ${calculadora.sumar(2, 3)}")
    println("Suma de 4 y memoria = ${calculadora.sumar(4)}")
    try {
        println("Resta de 5 / 0 = ${calculadora.dividir(5, 0)}")
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }

    val persona: Persona = Persona()
    try {
        persona.nombre = "jose perez"
        persona.edad = -12
    } catch (e: Exception) {
        println("Error: ${e.message}")
    } finally {
        println("Persona: ${persona.nombre} - ${persona.edad}")
    }

    val cuentaBancaria = CuentaBancariaProKotlin()
    cuentaBancaria.depositar(1000.0)
    cuentaBancaria.retirar(500.0)
    println("Saldo actual: $cuentaBancaria")
    println("Saldo en euros: ${cuentaBancaria.saldoAsEuro()}")
    println("Saldo en dólares: ${cuentaBancaria.getSaldo()}")

    val reloj = Reloj(13, 30, 0)
    println(reloj)
    println("Formato 24 horas:")
    reloj.imprimir()
    println("Formato 12 horas:")
    reloj.imprimir(false)

    reloj.horas = 23
    reloj.minutos = 59
    reloj.segundos = 55

    reloj.tickTack(100, true)


}

fun leerEntero(): Int {
    var i: Int?
    do {
        print("Introduce un número: ")
        i = readln().toIntOrNull()
        if (i == null) {
            println("Error: No es un número entero.")
        }
    } while (i == null)
    return i
}

fun leerEnteroRegex(): Int {
    var i: Int? = null
    do {
        print("Introduce un número: ")
        val input = readln().trim()
        if (input.matches(Regex("^[0-9]+$"))) {
            i = input.toInt()
        } else {
            println("Error: No es un número entero.")
        }
    } while (i == null)
    return i
}

fun leerEnteroException(): Int {
    var i: Int? = null
    do {
        print("Introduce un número: ")
        try {
            i = readln().toInt()
        } catch (e: NumberFormatException) {
            println("Error: No es un número entero.")
        }
    } while (i == null)
    return i
}