package nl.chrisb.aoc21.y20

import nl.chrisb.aoc21.common.Solution
import nl.chrisb.aoc21.common.cartesian
import nl.chrisb.aoc21.common.product
import nl.chrisb.aoc21.common.toInts

fun main() {
    Solution(2020, 1)
        .part1 {
            lines.toInts().cartesian().find { it.sum() == 2020 }?.product()
        }
        .part2 {
            lines.toInts().let { it.cartesian(it, it) }.find { it.sum() == 2020 }?.product()
        }
}
