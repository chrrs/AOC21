package nl.chrisb.aoc21.y20

import nl.chrisb.aoc21.common.Solution
import nl.chrisb.aoc21.common.binary
import nl.chrisb.aoc21.common.replacingRegex

fun main() {
    Solution(2020, 5)
        .part1 {
            lines
                .map { it.replacingRegex(mapOf(Regex("[FL]") to "0", Regex("[BR]") to "1")) }
                .map { it.binary() }
                .maxOrNull()
        }
        .part2 {
            lines
                .map { it.replacingRegex(mapOf(Regex("[FL]") to "0", Regex("[BR]") to "1")) }
                .map { it.binary() }
                .sorted()
                .zipWithNext()
                .first { it.first != it.second - 1 }.first + 1
        }
}
