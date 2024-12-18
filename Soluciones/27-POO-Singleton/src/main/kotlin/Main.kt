package dev.joseluisgs

fun main() {
    println("Singleton")

    println("Sin Singleton")
    val a = A()
    println(a)
    println(a.hashCode())
    val b = A()
    println(b)
    println(b.hashCode())
    val c = A()
    println(c)
    println(c.hashCode())

    println("Con Singleton de manual")
    val x = X.getInstance()
    println(x)
    println(x.hashCode())
    val y = X.getInstance()
    println(y)
    println(y.hashCode())
    val z = X.getInstance()
    println(z)
    println(z.hashCode())

    println("Con Singleton de Kotlin (object)")
    val s = S
    println(s)
    println(s.hashCode())
    val t = S
    println(t)
    println(t.hashCode())
    val u = S
    println(u)
    println(u.hashCode())
}