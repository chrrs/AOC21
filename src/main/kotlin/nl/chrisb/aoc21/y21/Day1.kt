package nl.chrisb.aoc21.y21

import nl.chrisb.aoc21.common.Solution
import nl.chrisb.aoc21.common.toInts

fun main() {
    Solution(2021, 1)
        .part1 {
            lines.toInts()
                .zipWithNext()
                .count { it.first < it.second }
        }
        .part2 {
            lines.toInts()
                .windowed(3)
                .map { it.sum() }
                .zipWithNext()
                .count { it.first < it.second }
        }
}
