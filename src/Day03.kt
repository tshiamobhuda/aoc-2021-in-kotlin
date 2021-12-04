fun main() {
    fun part1(input: List<String>): Int {
        var gamaRate = ""
        var epsilonRate = ""

        var index = 0
        while (index < input[0].length) {
            var zeroCounter = 0
            var oneCounter = 0

            for ((i, byte) in input.withIndex()) {
                if (byte[index] == '0') {
                    zeroCounter++
                } else {
                    oneCounter++
                }

                if (i == (input.size -1)) {
                    index += 1
                }
            }

            if (zeroCounter > oneCounter) {
                gamaRate += "0"
                epsilonRate += "1"
            } else {
                gamaRate += "1"
                epsilonRate += "0"
            }
        }

        return gamaRate.toInt(2) * epsilonRate.toInt(2)
    }

    fun part2(input: List<String>): Int {
        return 900
    }

    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
    println("[TEST]-part1: ${part1(testInput)}")
//    check(part2(testInput) == 900)
//    println("[TEST]-part2: ${part2(testInput)}")

    val input = readInput("Day03")
    println("--- AOC 2021 ---")
    println("[ANSWER]-part1: ${part1(input)}")
//    println("[ANSWER]-part2: ${part2(input)}")
}