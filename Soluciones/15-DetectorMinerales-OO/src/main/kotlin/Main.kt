import models.Configuracion
import models.SondaEspacial


fun main(args: Array<String>) {
    println("Detector de Minerales")

    val sonda = SondaEspacial(Configuracion())
    sonda.simulacion()

}

