package nl.chrisb.aoc21.y20

import nl.chrisb.aoc21.common.Solution
import nl.chrisb.aoc21.common.overallIntersection

object Day6 : Solution(2020, 6, "Custom Customs") {
    override fun part1(): Int {
        return input
            .split("\n\n")
            .map { it.lines() }
            .map { line -> line.fold(setOf<Char>()) { acc, s -> acc + s.toCharArray().toSet() } }
            .sumOf { it.size }
    }

    override fun part2(): Int {
        return input
            .split("\n\n")
            .map { it.lines() }
            .map { line -> line.map { it.toCharArray().toSet() }.overallIntersection() }
            .sumOf { it.size }
    }
}
