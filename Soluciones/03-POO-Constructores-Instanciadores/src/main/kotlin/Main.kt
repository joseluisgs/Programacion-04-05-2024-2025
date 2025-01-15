import models.estudiantes.Estudiante
import models.estudiantes.Expediente
import models.personas.*

fun main(args: Array<String>) {
    val persona1 = PersonaConstructorPorDefecto()
    persona1.nombre = "Juan"
    persona1.edad = 20
    persona1.genero = 'M'
    persona1.saludar()
    persona1.despedirse()
    println(persona1.isMayorEdad())

    var persona2 = PersonaConstructorPrimario("Ana", 30)
    persona2.saludar()
    persona2.despedirse()
    persona2.nombre = "Ana María"
    println(persona2.isMayorEdad())

    var persona3 = PersonaConstructorPrimarioEstado("Pedro", 40)
    persona3.saludar()
    persona3.despedirse()
    persona3.nombre = "Pedro Pablo"
    println(persona3.isMayorEdad())

    var persona4 = PersonaConstructorPrimarioEstado()
    persona3.saludar()
    persona3.despedirse()
    persona3.nombre = "Pedro Pablo"
    println(persona3.isMayorEdad())

    var persona5 = PersonaConstructorSecundario("María", 50, 'F')
    persona5.saludar()
    persona5.despedirse()
    persona5.nombre = "María José"
    println(persona5.isMayorEdad())

    var persona6 = PersonaConstructorInicializador("Luis", 60, 'M')
    persona6.saludar()
    persona6.despedirse()
    persona6.nombre = "Luis José"
    println(persona6.isMayorEdad())

    var estudiante1 = Estudiante("Juan", 20, Expediente())
    estudiante1.saludar()
    estudiante1.despedirse()
    estudiante1.mostrar()
    println(estudiante1.isAprobado())
    estudiante1.expediente.nota = 6.0
    println(estudiante1.isAprobado())
    estudiante1.expediente.nota = 4.0
    println(estudiante1.isAprobado())
    estudiante1.mostrar()

}