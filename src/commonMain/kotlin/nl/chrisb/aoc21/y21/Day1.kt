package nl.chrisb.aoc21.y21

import nl.chrisb.aoc21.common.Solution
import nl.chrisb.aoc21.common.toInts

class Day1 : Solution(2021, 1, "Sonar Sweep") {
    override fun part1(): Int {
        return lines.toInts()
            .zipWithNext()
            .count { it.first < it.second }
    }

    override fun part2(): Int {
        return lines.toInts()
            .windowed(3) { it.sum() }
            .zipWithNext()
            .count { it.first < it.second }
    }
}
