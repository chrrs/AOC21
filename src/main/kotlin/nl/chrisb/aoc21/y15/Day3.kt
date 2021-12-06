package nl.chrisb.aoc21.y15

import nl.chrisb.aoc21.common.Solution
import nl.chrisb.aoc21.common.Vec2

fun main() {
    Solution(2015, 3)
        .part1 {
            val visited = mutableSetOf(Vec2(0, 0))
            val current = Vec2(0, 0)

            input.forEach {
                when (it) {
                    '<' -> current.move(-1, 0)
                    '>' -> current.move(1, 0)
                    'v' -> current.move(0, -1)
                    '^' -> current.move(0, 1)
                }

                visited.add(current.copy())
            }

            visited.size
        }
        .part2 {
            val visited = mutableSetOf(Vec2(0, 0))
            val currentRobo = Vec2(0, 0)
            val currentReal = Vec2(0, 0)

            input.withIndex().forEach { (i, it) ->
                val current = if (i % 2 == 0) currentRobo else currentReal

                when (it) {
                    '<' -> current.move(-1, 0)
                    '>' -> current.move(1, 0)
                    'v' -> current.move(0, -1)
                    '^' -> current.move(0, 1)
                }

                visited.add(current.copy())
            }

            visited.size
        }
}
