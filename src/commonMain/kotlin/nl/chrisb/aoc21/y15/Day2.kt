package nl.chrisb.aoc21.y15

import nl.chrisb.aoc21.common.Solution
import nl.chrisb.aoc21.common.product
import nl.chrisb.aoc21.common.toInts

object Day2 : Solution(2015, 2, "I Was Told There Would Be No Math") {
    override fun part1(): Int {
        return lines.map { it.split("x").toInts() }
            .map { listOf(it[0] * it[1], it[1] * it[2], it[0] * it[2]) }
            .sumOf { it.sumOf { dim -> 2 * dim } + it.minOrNull()!! }
    }

    override fun part2(): Int {
        return lines.map { it.split("x").toInts() }
            .sumOf { it.sorted().dropLast(1).sum() * 2 + it.product() }
    }
}
