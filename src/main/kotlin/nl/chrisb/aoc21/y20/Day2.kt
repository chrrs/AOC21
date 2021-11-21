package nl.chrisb.aoc21.y20

import nl.chrisb.aoc21.common.Solution
import nl.chrisb.aoc21.common.groups
import nl.chrisb.aoc21.common.occurrences

fun main() {
    Solution(2020, 2)
        .part1 {
            lines.count {
                val groups = it.groups(Regex("(\\d+)-(\\d+) ([a-z]): (.*)"))

                val min = groups[0].toInt()
                val max = groups[1].toInt()

                (min..max).contains(groups[3].occurrences(groups[2][0]))
            }
        }
        .part2 {
            lines.count {
                val groups = it.groups(Regex("(\\d+)-(\\d+) ([a-z]): (.*)"))

                listOf(groups[0].toInt(), groups[1].toInt())
                    .filter { i -> groups[3].getOrNull(i - 1) == groups[2][0] }
                    .size == 1
            }
        }
}
