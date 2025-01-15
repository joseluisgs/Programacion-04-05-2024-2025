package dev.joseluisgs.models

class GuitarHero(nombre: String) : Musico(nombre), Guitarrista {
    override fun tocar() {
        super<Guitarrista>.tocar()
    }

}