package nl.chrisb.aoc21.y21

import nl.chrisb.aoc21.common.Solution
import nl.chrisb.aoc21.common.Vec2

object Day2 : Solution(2021, 2, "Dive!") {
    override fun part1(): Int {
        val location = Vec2(0, 0)

        lines.forEach {
            val parts = it.split(" ")
            val command = parts[0]
            val arg = parts[1].toInt()

            when (command) {
                "forward" -> location.move(arg, 0)
                "down" -> location.move(0, arg)
                "up" -> location.move(0, -arg)
            }
        }

        return location.x * location.y
    }

    override fun part2(): Int {
        val location = Vec2(0, 0)
        var aim = 0

        lines.forEach {
            val parts = it.split(" ")
            val command = parts[0]
            val arg = parts[1].toInt()

            when (command) {
                "forward" -> location.move(arg, arg * aim)
                "down" -> aim += arg
                "up" -> aim -= arg
            }
        }

        return location.x * location.y
    }
}
