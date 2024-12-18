fun main(args: Array<String>) {
    // inferir el tipo por el contenido
    var soyTodo: Any = "Hola"
    soyTodo = 1
    soyTodo = 1.0
    soyTodo = true

    if (soyTodo is String) {
        println(soyTodo.length)
    }

    // Ahora si queremos especificar el tipo
    var soyString: String = "Hola"
    var soyInt: Int = 1
    var soyDouble: Double = 1.0


    // Si queremos que una variable pueda ser nula
    //var miString = soyTodo as String
    var miString2: String? = soyTodo as? String ?: "No es un string"
    var miString3: Int = soyTodo as? Int ?: 0

    if (miString2 != null) {
        println(miString2.length)
    }

    println(miString2?.length)

    if (miString3 is Int) {
        println(miString3)
    }

    var arrayDeTodo: Array<Any?> = arrayOf("Hola", 1, 1.0, true, Unit, null)
    for (elemento in arrayDeTodo) {
        if (elemento is String) {
            println(elemento + " es una cadena de longitud: " + elemento.length)
        }
        if (elemento is Int) {
            println("$elemento es un entero")
        }
        if (elemento is Double) {
            println("$elemento es un double")
        }
        if (elemento is Boolean) {
            println("$elemento es un boolean")
        }
        if (elemento is Unit) {
            println("$elemento es un unit")
        }
        if (elemento == null) {
            println("$elemento es nulo")
        }

        var vectorEnteros: IntArray = IntArray(10)
        var vectorEnteros2: Array<Int> = Array(10) { 5 }
        var vectorEnteros3: Array<Int?> = Array(10) { null }

        for (i in 0..9) {
            println(vectorEnteros[i] * 2)
            println(vectorEnteros2[i] * 2)
            if (vectorEnteros3[i] != null) {
                println(vectorEnteros3[i]!! * 2)
            }

        }
    }
}

fun dimeNombre(): String? {
    return null
}