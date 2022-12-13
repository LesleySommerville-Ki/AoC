fun main() {
    val part1Scoring: Map<String, Int> =
        mapOf(
            "A X" to 1 + 3, // rock = 1
            "A Y" to 2 + 6, // paper = 2
            "A Z" to 3 + 0, // scissors = 3
            "B X" to 1 + 0,
            "B Y" to 2 + 3,
            "B Z" to 3 + 6,
            "C X" to 1 + 6,
            "C Y" to 2 + 0,
            "C Z" to 3 + 3,
        )

    val part2Scoring: Map<String, Int> =
        mapOf(
            "A X" to 3 + 0,
            "A Y" to 1 + 3,
            "A Z" to 2 + 6,
            "B X" to 1 + 0,
            "B Y" to 2 + 3,
            "B Z" to 3 + 6,
            "C X" to 2 + 0,
            "C Y" to 3 + 3,
            "C Z" to 1 + 6,
        )

    fun part1(input: List<String>): Int {
        return input.sumOf { part1Scoring[it] ?: 0 }
    }

    fun part2(input: List<String>): Int {
        return input.sumOf { part2Scoring[it] ?: 0 }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}