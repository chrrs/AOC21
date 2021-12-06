package nl.chrisb.aoc21.y15

import nl.chrisb.aoc21.common.Solution
import nl.chrisb.aoc21.common.between
import nl.chrisb.aoc21.common.groups
import nl.chrisb.aoc21.common.toInts
import kotlin.math.max

fun main() {
    Solution(2015, 6)
        .part1 {
            val lights = Array(1000) { Array(1000) { false } }

            lines.forEach { line ->
                val (op, a, b) = line.groups(Regex("(.*) (.*) through (.*)"))
                val c1 = a.split(",").toInts()
                val c2 = b.split(",").toInts()

                for (x in c1[0] between c2[0]) {
                    for (y in c1[1] between c2[1]) {
                        when (op) {
                            "turn on" -> lights[x][y] = true
                            "turn off" -> lights[x][y] = false
                            "toggle" -> lights[x][y] = !lights[x][y]
                        }
                    }
                }
            }

            lights.sumOf { it.count { light -> light } }
        }
        .part2 {
            val lights = Array(1000) { Array(1000) { 0 } }

            lines.forEach { line ->
                val (op, a, b) = line.groups(Regex("(.*) (.*) through (.*)"))
                val c1 = a.split(",").toInts()
                val c2 = b.split(",").toInts()

                for (x in c1[0] between c2[0]) {
                    for (y in c1[1] between c2[1]) {
                        when (op) {
                            "turn on" -> lights[x][y] += 1
                            "turn off" -> lights[x][y] = max(0, lights[x][y] - 1)
                            "toggle" -> lights[x][y] += 2
                        }
                    }
                }
            }

            lights.sumOf { it.sumOf { light -> light } }
        }
}
