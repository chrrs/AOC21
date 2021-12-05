package nl.chrisb.aoc21.y21

import nl.chrisb.aoc21.common.Solution
import nl.chrisb.aoc21.common.between
import nl.chrisb.aoc21.common.normalized
import nl.chrisb.aoc21.common.toInts
import kotlin.math.absoluteValue

fun main() {
    Solution(2021, 5)
        .part1 {
            val vents = Array(1000) { Array(1000) { 0 } }
            lines.forEach { line ->
                val parts = line.split(" -> ").flatMap { it.split(",") }.toInts()

                if (parts[0] == parts[2]) {
                    for (y in parts[1] between parts[3]) {
                        vents[parts[0]][y] += 1
                    }
                } else if (parts[1] == parts[3]) {
                    for (x in parts[0] between parts[2]) {
                        vents[x][parts[1]] += 1
                    }
                }
            }

            vents.flatten().count { it >= 2 }
        }
        .part2 {
            val vents = Array(1000) { Array(1000) { 0 } }
            lines.forEach { line ->
                val parts = line.split(" -> ").flatMap { it.split(",") }.toInts()

                if (parts[0] == parts[2]) {
                    for (y in parts[1] between parts[3]) {
                        vents[parts[0]][y] += 1
                    }
                } else if (parts[1] == parts[3]) {
                    for (x in parts[0] between parts[2]) {
                        vents[x][parts[1]] += 1
                    }
                } else if ((parts[0] - parts[2]).absoluteValue == (parts[1] - parts[3]).absoluteValue) {
                    val distance = (parts[2] - parts[0]).absoluteValue
                    val xDir = (parts[2] - parts[0]).normalized
                    val yDir = (parts[3] - parts[1]).normalized

                    for (i in 0..distance) {
                        vents[parts[0] + i * xDir][parts[1] + i * yDir] += 1
                    }
                }
            }

            vents.flatten().count { it >= 2 }
        }
}
