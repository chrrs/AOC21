package nl.chrisb.aoc21.y15

import nl.chrisb.aoc21.common.Solution

fun main() {
    Solution(2015, 5)
        .part1 {
            lines.count { line ->
                val vowels = line.filter { "aeiou".contains(it) }.length >= 3
                val twice = line.zipWithNext().any { (a, b) -> a == b }
                val contains = listOf("ab", "cd", "pq", "xy").any { line.contains(it) }

                vowels && twice && !contains
            }
        }
        .part2 {
            lines.count { line ->
                val pair = Regex("(.{2}).*\\1").containsMatchIn(line)
                val repeating = Regex("(.).\\1").containsMatchIn(line)

                pair && repeating
            }
        }
}
