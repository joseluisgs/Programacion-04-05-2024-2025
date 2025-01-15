package dev.joseluisgs.models

class Person(
    var name: String,
    var age: Int
) {

    override fun toString(): String {
        return "Person(name='$name', age=$age)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is Person) return false
        if (name != other.name) return false
        if (age != other.age) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + age
        return result
    }
}