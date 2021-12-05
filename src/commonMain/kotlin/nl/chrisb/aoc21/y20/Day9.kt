package nl.chrisb.aoc21.y20

import nl.chrisb.aoc21.common.Solution
import nl.chrisb.aoc21.common.cartesian
import kotlin.properties.Delegates

object Day9 : Solution(2020, 9, "Encoding Error") {
    private var invalid by Delegates.notNull<Long>()

    override fun part1(): Long {
        val buffer = mutableListOf<Long>()

        invalid = lines.map { it.toLong() }.first {
            if (buffer.size >= 25) {
                if (buffer.cartesian().all { pair -> pair[0] + pair[1] != it }) {
                    return@first true
                }

                buffer.removeAt(0)
            }

            buffer.add(it)
            false
        }

        return invalid
    }

    override fun part2(): Long {
        val numbers = lines.map { it.toLong() }

        return numbers.withIndex().firstNotNullOf { (i, n) ->
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

