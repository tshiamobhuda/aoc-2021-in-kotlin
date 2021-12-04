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

    fun generateORating(input: List<String>, start: Char): String {
        var rating = input.filter { v -> v.startsWith(start) }
        var index = 1

        while (rating.size != 1 && index <= (rating[0].length -1)) {
            var oneCounter = 0
            var zeroCounter = 0
            for ((i, rating) in rating.withIndex()) {
                if (rating[index] == '0') {
                    zeroCounter++
                } else {
                    oneCounter++
                }
            }

            if (oneCounter > zeroCounter || oneCounter == zeroCounter) {
                rating = rating.filter { v -> v[index] == '1'}
            } else {
                rating = rating.filter { v -> v[index] =='0' }
            }
            index++
        }

        return rating[0]
    }

    fun generateCRating(input: List<String>, start: Char): String {
        var rating = input.filter { v -> v.startsWith(start) }
        var index = 1

        while (rating.size != 1 && index <= (rating[0].length -1)) {
            var oneCounter = 0
            var zeroCounter = 0
            for ((i, rating) in rating.withIndex()) {
                if (rating[index] == '0') {
                    zeroCounter++
                } else {
                    oneCounter++
                }
            }

            if (oneCounter > zeroCounter || oneCounter == zeroCounter) {
                rating = rating.filter { v -> v[index] == '0'}
            } else if (zeroCounter > oneCounter) {
                rating = rating.filter { v -> v[index] == '1' }
            } else if (zeroCounter == oneCounter) {
                rating = rating.filter { v -> v[index] == '0' }
            }
            index++
        }

        return rating[0]
    }

    fun part2(input: List<String>): Int {
        var zeroCounter = 0
        var oneCounter = 0

        var oGRating = ""
        var cSRating = ""

        for ((i, byte) in input.withIndex()) {
            if (byte[0] == '0') {
                zeroCounter++
            } else {
                oneCounter++
            }
        }

        if (zeroCounter > oneCounter) {
            oGRating = generateORating(input, '0')
            cSRating = generateCRating(input, '1')
        } else {
            oGRating = generateORating(input, '1')
            cSRating = generateCRating(input, '0')
        }

        return oGRating.toInt(2) * cSRating.toInt(2)
    }

    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
    println("[TEST]-part1: ${part1(testInput)}")
    check(part2(testInput) == 230)
    println("[TEST]-part2: ${part2(testInput)}")

    val input = readInput("Day03")
    println("--- AOC 2021 ---")
    println("[ANSWER]-part1: ${part1(input)}")
    println("[ANSWER]-part2: ${part2(input)}")
}