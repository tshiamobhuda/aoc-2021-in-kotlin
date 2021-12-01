fun main() {
    fun part1(input: List<String>): Int {
        var depthIncreases = 0
        var prevDepth = ""

        for ((index, depth) in input.withIndex()) {
            if (index == 0) {
                prevDepth = depth

                continue
            }

            if (depth.toInt() > prevDepth.toInt()) {
                depthIncreases++
            }

            prevDepth = depth
        }

        return depthIncreases
    }

    fun part2(input: List<String>): Int {
        var index = 0
        var increases = 0
        var prevDepthWithWindows = 0
        while (index < input.size - 2) {
            val regex = Regex("(\\d+)")
            val window1 = regex.find(input[index])?.value?.toInt() ?: 0
            val window2 = regex.find(input[index +1])?.value?.toInt() ?: 0
            val window3 = regex.find(input[index + 2])?.value?.toInt() ?: 0
            val sum = window1 + window2 + window3

            if (sum > prevDepthWithWindows && index != 0) {
                increases++
            }

            prevDepthWithWindows = sum
            index++
        }

        return increases
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    println("[TEST]-part1: ${part1(testInput)}")
    check(part2(testInput) == 5)
    println("[TEST]-part2: ${part2(testInput)}")

    val input = readInput("Day01")
    println("--- AOC 2021 ---")
    println("[ANSWER]-part1: ${part1(input)}")
    println("[ANSWER]-part2: ${part2(input)}")
}
