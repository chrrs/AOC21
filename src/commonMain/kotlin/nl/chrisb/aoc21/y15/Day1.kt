package nl.chrisb.aoc21.y15

import nl.chrisb.aoc21.common.Solution
import nl.chrisb.aoc21.common.frequency

object Day1 : Solution(2015, 1, "Not Quite Lisp") {
    override fun part1(): Int {
        val frequency = input.frequency()
        return frequency['(']!! - frequency[')']!!
    }

    override fun part2(): Int {
        var floor = 0
        return input.withIndex().first { (_, c) ->
            if (c == '(') {
                floor += 1
            } else {
                floor -= 1
            }

            floor < 0
        }.index + 1
    }
}
