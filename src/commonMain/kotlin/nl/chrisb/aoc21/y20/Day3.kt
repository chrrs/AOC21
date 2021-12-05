package nl.chrisb.aoc21.y20

import nl.chrisb.aoc21.common.Solution
import nl.chrisb.aoc21.common.countIndexed
import nl.chrisb.aoc21.common.product
import nl.chrisb.aoc21.common.rollingAt

object Day3 : Solution(2020, 3, "Toboggan Trajectory") {
    override fun part1(): Int {
        return trees(3, 1)
    }

    override fun part2(): Int {
        return listOf(
            trees(1, 1),
            trees(3, 1),
            trees(5, 1),
            trees(7, 1),
            trees(1, 2),
        ).product()
    }

    private fun trees(right: Int, down: Int) =
        lines
            .filterIndexed { y, _ -> y % down == 0 }
            .countIndexed { y, x -> x.rollingAt(y * right) == '#' }
}
