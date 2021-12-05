package nl.chrisb.aoc21.y20

import nl.chrisb.aoc21.common.Solution
import nl.chrisb.aoc21.common.groups
import nl.chrisb.aoc21.common.occurrences

fun main() {
    Solution(2020, 2)
        .part1 {
            lines.count {
                val (a, b, c, pass) = it.groups(Regex("(\\d+)-(\\d+) ([a-z]): (.*)"))

                (a.toInt()..b.toInt()).contains(pass.occurrences(c[0]))
            }
        }
        .part2 {
            lines.count {
                val (a, b, c, pass) = it.groups(Regex("(\\d+)-(\\d+) ([a-z]): (.*)"))

                listOf(a.toInt(), b.toInt())
                    .filter { i -> pass.getOrNull(i - 1) == c[0] }
                    .size == 1
            }
        }
}
