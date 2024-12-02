package dev.joseluisgs.utils

import kotlin.math.pow

class Utils {
    companion object {
        fun rounded(value: Double, places: Int): Double {
            if (places < 0) throw IllegalArgumentException()
            return Math.round(value * 10.0.pow(places.toDouble())) / 10.0.pow(places.toDouble())
        }
    }
}