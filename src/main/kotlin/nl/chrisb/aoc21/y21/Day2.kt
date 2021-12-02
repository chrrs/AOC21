package nl.chrisb.aoc21.y21

import nl.chrisb.aoc21.common.Solution
import java.awt.Point

fun main() {
    Solution(2021, 2)
        .part1 {
            val location = Point(0, 0)

            lines.forEach {
                val parts = it.split(" ")
                val command = parts[0]
                val arg = parts[1].toInt()

                when (command) {
                    "forward" -> location.translate(arg, 0)
                    "down" -> location.translate(0, arg)
                    "up" -> location.translate(0, -arg)
                }
            }

            location.x * location.y
        }
        .part2 {
            val location = Point(0, 0)
            var aim = 0

            lines.forEach {
                val parts = it.split(" ")
                val command = parts[0]
                val arg = parts[1].toInt()

                when (command) {
                    "forward" -> location.translate(arg, arg * aim)
                    "down" -> aim += arg
                    "up" -> aim -= arg
                }
            }

            location.x * location.y
        }
}
