fun main() {
    fun parseWindows(input: List<String>, minChars: Int): Int {
        val windows = input[0].windowed(size = minChars, step = 1)
        fun String.allUnique(): Boolean = all(hashSetOf<Char>()::add)
        for (i in 1 until windows.size) {
            if (windows[i].allUnique()) {
                return (i + minChars)
            }
        }
        return 0
    }

    fun part1(input: List<String>): Int {
        return parseWindows(input, 4)
    }

    fun part2(input: List<String>): Int {
        return parseWindows(input, 14)
    }

    val testInput = readInput("Day06_test")
    check(part1(testInput) == 5)

    val input = readInput("Day06")
    part1(input).println()
    part2(input).println()
}