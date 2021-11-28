package nl.chrisb.aoc21.y15

import nl.chrisb.aoc21.common.Solution
import java.awt.Point

fun main() {
    Solution(2015, 3)
        .part1 {
            val visited = mutableSetOf(Point(0, 0))
            val current = Point(0, 0)

            input.forEach {
                when (it) {
                    '<' -> current.translate(-1, 0)
                    '>' -> current.translate(1, 0)
                    'v' -> current.translate(0, -1)
                    '^' -> current.translate(0, 1)
                }

                visited.add(Point(current))
            }

            visited.size
        }
        .part2 {
            val visited = mutableSetOf(Point(0, 0))
            val currentRobo = Point(0, 0)
            val currentReal = Point(0, 0)

            input.withIndex().forEach { (i, it) ->
                val current = if (i % 2 == 0) currentRobo else currentReal

                when (it) {
                    '<' -> current.translate(-1, 0)
                    '>' -> current.translate(1, 0)
                    'v' -> current.translate(0, -1)
                    '^' -> current.translate(0, 1)
                }

                visited.add(Point(current))
            }

            visited.size
        }
}
