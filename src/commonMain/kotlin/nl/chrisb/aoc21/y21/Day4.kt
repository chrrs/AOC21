package nl.chrisb.aoc21.y21

import nl.chrisb.aoc21.common.Solution
import nl.chrisb.aoc21.common.toInts

object Day4 : Solution(2021, 4, "Giant Squid") {
    private lateinit var numbers: List<Int>
    private lateinit var boards: List<List<List<Int?>>>

    override fun part1(): Int {
        val parts = input.split("\n\n")
        numbers = parts[0].split(",").toInts()
        boards = parts.drop(1)
            .map { board ->
                board.split("\n").map { line ->
                    line.trim()
                        .split(Regex(" +"))
                        .map { it.toIntOrNull() }
                }
            }

        return numbers.firstNotNullOf { n ->
            boards = boards.map { board -> board.map { line -> line.map { if (it == n) null else it } } }
            val winner = boards.find { it.hasBingo() }
            winner?.let { it.unmarkedSum() * n }
        }
    }

    override fun part2(): Int? {
        return numbers.firstNotNullOfOrNull { n ->
            boards = boards.map { board -> board.map { line -> line.map { if (it == n) null else it } } }

            if (boards.size > 1) {
                boards = boards.filter { !it.hasBingo() }
                null
            } else {
                boards.firstOrNull { it.hasBingo() }?.let { it.unmarkedSum() * n }
            }
        }
    }

    private fun List<List<Int?>>.hasBingo() = any { line -> line.all { it == null } } ||
            (0 until get(0).size).any { col -> all { line -> line[col] == null } }

    private fun List<List<Int?>>.unmarkedSum() = sumOf { line -> line.sumOf { it ?: 0 } }
}
