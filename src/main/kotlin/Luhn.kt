object Luhn {

    fun isValid(candidate: String): Boolean {
        // Remove all spaces in candidate string
        val noSpaces = candidate.replace(" ", "")

        if (noSpaces.length <= 1) {
            return false
        }

        // Check that only numbers are left in candidate string
        // If not return false
        if (!noSpaces.all { char ->
                char.toInt() in '0'.toInt()..'9'.toInt()
            }) {
            return false
        }

        val sum = noSpaces
            .reversed()
            .map { it.toString().toInt() }
            .mapIndexed { index, num ->
                if (index % 2 != 0) {
                    val doubled = num * 2
                    if (doubled > 9) {
                        doubled - 9
                    } else {
                        doubled
                    }
                } else {
                    num
                }
            }.sum()

        return sum % 10 == 0
    }
}
