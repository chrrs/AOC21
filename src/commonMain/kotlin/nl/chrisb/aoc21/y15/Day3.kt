package nl.chrisb.aoc21.y15

import nl.chrisb.aoc21.common.Solution
import nl.chrisb.aoc21.common.Vec2

object Day3 : Solution(2015, 3, "Perfectly Spherical Houses in a Vacuum") {
    override fun part1(): Int {
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

        return visited.size
    }

    override fun part2(): Int {
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

        return visited.size
    }
}
