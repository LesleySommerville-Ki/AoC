fun main() {
    fun part1(input: List<String>): Int {
        var totalNumber = 0
        input.forEach {
            val split = it.split(",")

            val start = split[0].split("-")[0].toInt()
            val end = split[0].split("-")[1].toInt()
            val array = (start.. end).toList().toMutableSet()

            val start2 = split[1].split("-")[0].toInt()
            val end2 = split[1].split("-")[1].toInt()
            val array2 = (start2.. end2).toList().toMutableSet()

            val isSubArr = array + array2
            if ( isSubArr.size === array.size || isSubArr.size === array2.size) {
                totalNumber += 1
            }
        }
        return totalNumber
    }

    fun part2(input: List<String>): Int {
        var totalNumber = 0
        input.forEach {
            val split = it.split(",")

            val start = split[0].split("-")[0].toInt()
            val end = split[0].split("-")[1].toInt()
            val array = (start.. end).toList().toSet()

            val start2 = split[1].split("-")[0].toInt()
            val end2 = split[1].split("-")[1].toInt()
            val array2 = (start2.. end2).toList().toSet()

            val intersect = array.intersect(array2)
            if (intersect.isNotEmpty()) {
                totalNumber += 1
            }
        }
        return totalNumber
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)

    val input = readInput("Day04")
    part1(input).println()
    part2(input).println()
}