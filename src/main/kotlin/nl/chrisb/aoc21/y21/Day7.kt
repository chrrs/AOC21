package nl.chrisb.aoc21.y21

import nl.chrisb.aoc21.common.Solution
import nl.chrisb.aoc21.common.toInts
import kotlin.math.absoluteValue

fun main() {
    Solution(2021, 7)
        .part1 {
            val positions = input.split(",").toInts()
            (positions.minOrNull()!!..positions.maxOrNull()!!).map { n ->
                positions.sumOf { (it - n).absoluteValue }
            }.minOrNull()
        }
        .part2 {
            val positions = input.split(",").toInts()
            (positions.minOrNull()!!..positions.maxOrNull()!!).map { n ->
                positions.sumOf {
                    val offset = (it - n).absoluteValue
                    ((offset + 1) * offset) / 2
                }
            }.minOrNull()
        }
}
