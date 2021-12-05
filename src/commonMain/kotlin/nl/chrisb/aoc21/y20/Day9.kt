package nl.chrisb.aoc21.y20

import nl.chrisb.aoc21.common.Solution
import nl.chrisb.aoc21.common.cartesian

fun main() {
    Solution(2020, 9)
        .part1 {
            invalidNumber()
        }
        .part2 {
            val invalid = invalidNumber()
            val numbers = lines.map { it.toLong() }

            numbers.withIndex().firstNotNullOf { (i, n) ->
                var j = i + 1
                var accumulator = n

                while (accumulator < invalid) {
                    accumulator += numbers[j]
                    j++
                }

                if (accumulator == invalid) {
                    val range = (i until j).map { numbers[it] }
                    range.minOrNull()!! + range.maxOrNull()!!
                } else {
                    null
                }
            }
        }
}

fun Solution.invalidNumber(): Long {
    val buffer = mutableListOf<Long>()

    return lines.map { it.toLong() }.first {
        if (buffer.size >= 25) {
            if (buffer.cartesian().all { pair -> pair[0] + pair[1] != it }) {
                return@first true
            }

            buffer.removeAt(0)
        }

        buffer.add(it)
        false
    }
}

