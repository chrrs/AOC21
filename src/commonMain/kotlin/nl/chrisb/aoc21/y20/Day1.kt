package nl.chrisb.aoc21.y20

import nl.chrisb.aoc21.common.Solution
import nl.chrisb.aoc21.common.cartesian
import nl.chrisb.aoc21.common.product
import nl.chrisb.aoc21.common.toInts

object Day1 : Solution(2020, 1, "Report Repair") {
    override fun part1(): Int? {
        return lines.toInts().cartesian().find { it.sum() == 2020 }?.product()
    }

    override fun part2(): Int? {
        return lines.toInts().let { it.cartesian(it, it) }.find { it.sum() == 2020 }?.product()
    }
}
