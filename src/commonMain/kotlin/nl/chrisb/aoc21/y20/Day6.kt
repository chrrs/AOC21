package nl.chrisb.aoc21.y20

import nl.chrisb.aoc21.common.Solution
import nl.chrisb.aoc21.common.overallIntersection

fun main() {
    Solution(2020, 6)
        .part1 {
            input
                .split("\n\n")
                .map { it.lines() }
                .map { line -> line.fold(setOf<Char>()) { acc, s -> acc + s.toCharArray().toSet() } }
                .sumOf { it.size }
        }
        .part2 {
            input
                .split("\n\n")
                .map { it.lines() }
                .map { line -> line.map { it.toCharArray().toSet() }.overallIntersection() }
                .sumOf { it.size }
        }
}
