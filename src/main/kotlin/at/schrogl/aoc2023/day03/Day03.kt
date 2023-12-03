package at.schrogl.aoc2023.day03

class Day03 {

    private fun parseInput(filename: String): Array<CharArray> = Day03::class.java.getResource(filename)!!
            .readText()
            .lines()
            .map(String::toCharArray)
            .toTypedArray()

    private fun computeTask1(filename: String) {
        parseInput(filename).forEachIndexed { rowIdx, lineChars ->
            
        }
    }

    fun start() {
        println(
                """
                Day 03 :: Task 1
                input-example.txt => ${computeTask1("input-example.txt")} 
                input.txt => ${computeTask1("input.txt")}
            """.trimIndent()
        )
    }
}

fun main() {
    Day03().start()
}
