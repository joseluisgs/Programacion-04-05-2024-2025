package factories

import models.Droid
import models.Sw348
import models.Sw421
import models.Sw447

class DroidsFactory {

    companion object {
        /**
         * Generates a random Droid object with various properties.
         *
         * @return A randomly generated Droid object.
         */
        fun random(): Droid {
            val random = (1..100).random()
            return when {
                random <= 30 -> Sw348(50, (9..12).random())
                random <= 80 -> Sw447(100, (5..10).random())
                else -> Sw421((100..150).random(), (10..30).random())
            }
        }

        /**
         * Creates a Droid object based on the given Type.
         *
         * @param type The type of the Droid. It can be one of the following: SW348, SW447, or SW421.
         * @return A Droid object with the specified type. The Droid object's properties are set based on the given type.
         */
        fun fromType(type: Type): Droid {
            return when (type) {
                Type.SW348 -> Sw348(50, (9..12).random())
                Type.SW447 -> Sw447(100, (5..10).random())
                Type.SW421 -> Sw421((100..150).random(), (10..30).random())
            }
        }
    }

    // Una clase anidada
    enum class Type {
        SW348, SW447, SW421
    }
}