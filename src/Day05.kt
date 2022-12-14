fun main() {
    data class Instructions(
        val amount: Int,
        val from: Int,
        val to: Int
    )

    fun parseInstructions(input: List<String>): List<Instructions> =
        input
            .dropWhile { !it.startsWith("move") }
            .map { row ->
                row.split(" ").let { parts ->
                    Instructions(parts[1].toInt(), parts[3].toInt() - 1, parts[5].toInt() - 1)
                }
            }

    fun readStacks(input: List<String>): List<MutableList<Char>> {
        val stackRows = input.takeWhile { it.contains('[') }
        return (1..stackRows.last().length step 4).map { index ->
            stackRows
                .mapNotNull { it.getOrNull(index) }
                .filter { it.isUpperCase() }
                .toMutableList()
        }
    }

    fun parseInstructions(
        instructions: List<Instructions>,
        stacks: List<MutableList<Char>>,
        reverse: Boolean
    ) {
        instructions.forEach { (amount, source, destination) ->
            val toBeMoved = stacks[source].take(amount)
            repeat(amount) { stacks[source].removeFirst() }
            stacks[destination].addAll(0, if (reverse) toBeMoved.reversed() else toBeMoved)
        }
    }

    fun part1(input: List<String>): String {
        val stacks: List<MutableList<Char>> = readStacks(input)
        val instructions: List<Instructions> = parseInstructions(input)

        parseInstructions(instructions, stacks, true)
        return stacks.map { it.first() }.joinToString("")
    }

    fun part2(input: List<String>): String {
        val stacks: List<MutableList<Char>> = readStacks(input)
        val instructions: List<Instructions> = parseInstructions(input)

        parseInstructions(instructions, stacks, false)
        return stacks.map { it.first() }.joinToString("")
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    check(part1(testInput) == "CMZ")

    val input = readInput("Day05")
    part1(input).println()
    part2(input).println()
}