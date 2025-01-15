import models.coches.Vehiculo
import models.personas.Persona
import models.personas.constructor.PersonaConConstructor
import models.personas.constructor.PersonaConConstructorRestricciones
import models.personas.constructor.PersonaConConstructorRestriccionesSoloLectura
import models.personas.kotlin.PersonaKotlin
import models.personas.privada.PersonaPrivada
import models.personas.privada.PersonaPrivadaRequire
import models.personas.privada.PersonaPrivadaRestricciones
import models.coches.Persona as PersonaCoche

fun main(args: Array<String>) {
    val persona = Persona()
    persona.nombre = "Juan"
    persona.edad = -25
    persona.mostrar()

    val personaPrivada = PersonaPrivada()
    personaPrivada.setNombre("Juan")
    personaPrivada.setEdad(-25)
    personaPrivada.mostrar()

    val personaPrivadaRestricciones = PersonaPrivadaRestricciones()
    personaPrivadaRestricciones.setNombre("Juan")
    // personaPrivadaRestricciones.setEdad(-25)
    personaPrivadaRestricciones.mostrar()

    val personaPrivadaRequire = PersonaPrivadaRequire()
    personaPrivadaRequire.setNombre("Juan")
    // personaPrivadaRequire.setEdad(-25)
    personaPrivadaRequire.mostrar()

    val personaConConstructor = PersonaConConstructor("Antonio", -25)
    personaConConstructor.setNombre("Juan")
    // personaConConstructor.setEdad(-25)
    personaConConstructor.mostrar()

    val personaConConstructorRestricciones = PersonaConConstructorRestricciones("Antonio", 25)
    // val personaConConstructorRequire = PersonaConConstructorRequire("Antonio", -25) // exception
    personaConConstructorRestricciones.setNombre("Juan")
    // personaConConstructorRestricciones.setEdad(-25)
    personaConConstructorRestricciones.mostrar()
    // personaConConstructorRestricciones.soyPrivada // No me ves

    val personaConConstructorRequireSoloLectura = PersonaConConstructorRestriccionesSoloLectura("Antonio", 25)
    // personaConConstructorRequireSoloLectura.setNombre("Juan")
    // personaConConstructorRequireSoloLectura.setEdad(-25)
    personaConConstructorRequireSoloLectura.mostrar()

    val personaKotlin = PersonaKotlin("Antonio", 25)
    // personaKotlin.nombre = "Juan"
    personaKotlin.edad = 25 // exception!! Como lo arreglo!!!
    personaKotlin.mostrar()
    personaKotlin.apellidos = "Perez"
    personaKotlin.mostrar()

    val personaVehiculo = PersonaCoche(
        dni = "12345678",
        _nombre = "Juan",
        _edad = 25,
        vehiculo = Vehiculo("1234ABC", "Renault", "5")
    )

    personaVehiculo.mostrar()
    personaVehiculo.nombre = "Pedro"
    personaVehiculo.edad = 20
    personaVehiculo.mostrar()


}

