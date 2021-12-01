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
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    println(part1(testInput))

    val input = readInput("Day01")
    println(part1(input))
//    println(part2(input))
}
