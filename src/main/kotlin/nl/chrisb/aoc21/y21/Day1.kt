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
            val ints = lines.toInts()
            ints.dropLast(2)
                .mapIndexed { i, c -> c + ints[i + 1] + ints[i + 2] }
                .zipWithNext()
                .count { it.first < it.second }
        }
}
