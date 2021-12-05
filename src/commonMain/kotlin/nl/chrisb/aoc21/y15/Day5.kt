package nl.chrisb.aoc21.y15

import nl.chrisb.aoc21.common.Solution

object Day5 : Solution(2015, 5, "Doesn't He Have Intern-Elves For This?") {
    override fun part1(): Int {
        return lines.count { line ->
            val vowels = line.filter { "aeiou".contains(it) }.length >= 3
            val twice = line.zipWithNext().any { (a, b) -> a == b }
            val contains = listOf("ab", "cd", "pq", "xy").any { line.contains(it) }

            vowels && twice && !contains
        }
    }

    override fun part2(): Int {
        return lines.count { line ->
            val pair = Regex("(.{2}).*\\1").containsMatchIn(line)
            val repeating = Regex("(.).\\1").containsMatchIn(line)

            pair && repeating
        }
    }
}
