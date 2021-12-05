package nl.chrisb.aoc21.y15

import nl.chrisb.aoc21.common.Solution
import nl.chrisb.aoc21.common.frequency

fun main() {
    Solution(2015, 1)
        .part1 {
            val frequency = input.frequency()
            frequency['(']!! - frequency[')']!!
        }
        .part2 {
            var floor = 0
            input.withIndex().first { (_, c) ->
                if (c == '(') {
                    floor += 1
                } else {
                    floor -= 1
                }

                floor < 0
            }.index + 1
        }
}
