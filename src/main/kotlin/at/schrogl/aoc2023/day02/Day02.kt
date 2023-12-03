package at.schrogl.aoc2023.day02

class Day02 {

    private fun parseInput(filename: String) = Day02::class.java.getResource(filename)
        .readText()
        .lines()
        .filter(String::isNotBlank)
        .map { line ->
            GameData(
                id = line.substringBefore(':').substringAfter(' ').trim().toLong(),
                sets = line.substringAfter(':').trim().split(';')
                    .map { set ->
                        val revealedCubes = mutableMapOf<String, Long>()
                        set.trim().split(',').map { cubeReveal ->
                            cubeReveal.trim().split(' ').let { revealedCubes.put(it[1], it[0].toLong()) }
                        }
                        Triple(
                            first = revealedCubes["red"] ?: 0,
                            second = revealedCubes["green"] ?: 0,
                            third = revealedCubes["blue"] ?: 0,
                        )
                    }
            )
        }

    data class GameData(
        val id: Long,
        val sets: List<Triple<Long, Long, Long>>
    )

    fun computeTask1(filename: String): Long {
        val limit = Triple(12L, 13L, 14L)
        return parseInput(filename)
            .filter { game ->
                game.sets.all { set ->
                    set.first <= limit.first && set.second <= limit.second && set.third <= limit.third
                }
            }
            .sumOf { possibleGame -> possibleGame.id }
    }

    fun start() {
        println(
            """
                Day 02 :: Task 1
                input-task1-example.txt => ${computeTask1("input-task1-example.txt")} 
                input.txt => ${computeTask1("input.txt")}
            """.trimIndent()
        )
    }
}

fun main() {
    Day02().start()
}