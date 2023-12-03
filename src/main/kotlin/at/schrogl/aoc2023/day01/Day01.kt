package at.schrogl.aoc2023.day01

class Day01 {
    private fun computeTask1(filename: String) = Day01::class.java.getResource(filename)!!
        .readText()
        .lines()
        .filter(String::isNotBlank)
        .sumOf { token ->
            token.first(Char::isDigit).plus(token.last(Char::isDigit).toString()).toLong()
        }

    private fun computeTask2(filename: String) = Day01::class.java.getResource(filename)!!
        .readText()
        .lines()
        .filter(String::isNotBlank)
        .sumOf { token ->
            val leftPair1 = token.findAnyOf(Num.getWords(), ignoreCase = true)
                ?.let { Pair(it.first, Num.fromWord(it.second).number) }
                ?: Pair(Int.MAX_VALUE, null)
            val leftPair2 = token.indexOfFirst(Char::isDigit)
                .let { if (it == -1) Pair(Int.MAX_VALUE, null) else Pair(it, token[it].toString().toLong()) }

            val rightPair1 = token.findLastAnyOf(Num.getWords(), ignoreCase = true)
                ?.let { Pair(it.first, Num.fromWord(it.second).number) }
                ?: Pair(Int.MIN_VALUE, null)
            val rightPair2 = token.indexOfLast(Char::isDigit)
                .let { if (it == -1) Pair(Int.MIN_VALUE, null) else Pair(it, token[it].toString().toLong()) }

            val leftNumber = if (leftPair1.first < leftPair2.first) leftPair1.second!! else leftPair2.second!!
            val rightNumber = if (rightPair1.first > rightPair2.first) rightPair1.second!! else rightPair2.second!!

            return@sumOf leftNumber.times(10).plus(rightNumber)
        }

    enum class Num(
        val word: String,
        val number: Long,
    ) {
        ONE("one", 1),
        TWO("two", 2),
        THREE("three", 3),
        FOUR("four", 4),
        FIVE("five", 5),
        SIX("six", 6),
        SEVEN("seven", 7),
        EIGHT("eight", 8),
        NINE("nine", 9);

        companion object {
            fun getWords() = Num.entries.map { it.word }
            fun fromWord(word: String) = Num.entries.first { it.word == word }
        }
    }

    fun start() {
        println(
            """
                    Day 01 :: Task 1
                    input-example.txt => ${computeTask1("input-example.txt")}
                    input.txt => ${computeTask1("input.txt")}
                    
                    Day 01 :: Task 2
                    input-task2-example.txt => ${computeTask2("input-task2-example.txt")}
                    input.txt => ${computeTask2("input.txt")}
                """.trimIndent()
        )
    }
}

fun main() {
    Day01().start()
}
