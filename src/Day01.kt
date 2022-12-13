fun main() {
    data class Elf (
        var calories: Int? = 0
    )

    fun parseElves(input: List<String>): ArrayDeque<Elf> {
        val listOfElves = ArrayDeque<Elf>()
        var currentElf = Elf()
        input.forEach {
            if (it == "") {
                listOfElves.add(currentElf)
                currentElf = Elf(0)
            } else {
                currentElf.calories = currentElf.calories?.plus(it.toInt())
            }
        }
        return listOfElves
    }

    fun part1(input: List<String>): Int {
        return parseElves(input).maxOf { it.calories!!.toInt() }
    }

    fun part2(input: List<String>): Int {
        val elves = parseElves(input)
        return elves.map { it.calories }.sortedByDescending { it }.take(3).sumOf { it!!.toInt() }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
