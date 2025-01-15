package dev.joseluisgs.models

class CafeteraConSuperCalentador : ICalentador, ICalentadorElectrico {
    override fun calentar() {
        println("Calentando con Super Calentador")
    }

    override fun enfriar() {
        println("Enfriando con Super Calentador")
    }

    // Obligatoriamente tengo que implementar el método experimento, para decir de donde viene
    override fun experimento() {
        // Opción 1: Implementación propia
        println("Esto es un experimento de CafeteraConSuperCalentador")

        // Opción 2: Implementación de ICalentador
        super<ICalentador>.experimento()

        // Opción 3: Implementación de ICalentadorElectrico
        super<ICalentadorElectrico>.experimento()

        // Opción 4: TODOS
        super<ICalentador>.experimento()
        super<ICalentadorElectrico>.experimento()
    }


}