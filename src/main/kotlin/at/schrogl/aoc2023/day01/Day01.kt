package at.schrogl.aoc2023.day01

class Day01 {
    private fun processInput(filename: String) = Day01::class.java.getResource(filename)!!
            .readText()
            .lines()
            .filter(String::isNotBlank)
            .sumOf { token ->
                token.first(Char::isDigit).plus(token.last(Char::isDigit).toString()).toLong()
            }

    fun start() {
        println(
                """
                    Day 01 :: Task 1
                    input-test.txt => ${processInput("input-test.txt")}
                    input.txt => ${processInput("input.txt")}
                """.trimIndent()
        )
    }
}

fun main() { Day01().start() }
