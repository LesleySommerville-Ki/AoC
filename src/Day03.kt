fun main() {
    fun getItemPriority(char: Char): Int {
        val lowerCase = "abcdefghijklmnopqrstuvwxyz"
        val upperCase = "abcdefghijklmnopqrstuvwxyz".toUpperCase()
        return if (char.isUpperCase() ) upperCase.indexOf(char) + 27 else {
            lowerCase.indexOf(char) + 1
        }
    }

    data class Item (
        val char: Char = '\u0000',
        val priority: Int = 0
    )

    fun createItemList(
        input: List<String>,
        currentItem: Item,
        listOfItems: ArrayDeque<Item>,
    ) {
        var currentItem1 = currentItem
        input.forEach { line ->
            val chunked = line.chunked(line.length / 2)
            val common = chunked[0].toList().intersect(chunked[1].toList().toSet())
            currentItem1 = Item(char = common.first().toChar(), getItemPriority(common.first().toChar()))
            listOfItems.add(currentItem1)
        }
    }

    fun part1(input: List<String>): Int {
        val listOfItems = ArrayDeque<Item>()
        var currentItem = Item()
        createItemList(input, currentItem, listOfItems)
        return listOfItems.sumOf { it.priority }
    }

    fun part2(input: List<String>): Int {
        val listOfItems = ArrayDeque<Item>()
        var currentItem: Item
        val split = input.chunked(3)
        for (strings in split) {
            val item = strings[0].filter(strings[1]::contains).toSet().filter(strings[2]::contains).toSet().first().toChar()
            currentItem = Item(char = item, getItemPriority(item))
            listOfItems.add(currentItem)
        }
        return listOfItems.sumOf { it.priority }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)

    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}