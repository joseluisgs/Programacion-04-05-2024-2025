package dev.joseluisgs.models

enum class Animal(val sonido: String, val patas: Int = 4) {
    PERRO("guau guau"),
    GATO("miau miau"),
    VACA("muuuu"),
    CABALLO("hiiiiii"),
    GALLO("kikiriki", 2),
    GALLINA("kikiriki", 2)
    
}