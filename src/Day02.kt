fun main() {
    fun part1(input: List<String>): Int {
        var position = 0
        var depth = 0
        val r = Regex("(\\w+)\\s+(\\d+)")

        for (command in input) {
            val matches = r.matchEntire(command)
            val direction = matches?.groups?.get(1)?.value.toString()
            val amount = matches?.groups?.get(2)?.value?.toInt() ?:0

            when (direction) {
                "forward" -> position += amount
                "down" -> depth += amount
                "up" -> depth -= amount
            }
        }

        return position * depth
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    println("[TEST]-part1: ${part1(testInput)}")
//    check(part2(testInput) == 5)
//    println("[TEST]-part2: ${part2(testInput)}")

    val input = readInput("Day02")
    println("--- AOC 2021 ---")
    println("[ANSWER]-part1: ${part1(input)}")
//    println("[ANSWER]-part2: ${part2(input)}")
}