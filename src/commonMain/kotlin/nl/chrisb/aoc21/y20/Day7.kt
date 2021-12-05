package nl.chrisb.aoc21.y20

import nl.chrisb.aoc21.common.Solution
import nl.chrisb.aoc21.common.groups

object Day7 : Solution(2020, 7, "Handy Haversacks") {
    lateinit var bags: Map<String, Map<String, Int>>

    override fun part1(): Int {
        bags = lines.associate {
            val (first, second) = it.groups(Regex("(.*) bags contain (.*)."))
            first to second
        }.mapValues { bag ->
            if (bag.value == "no other bags") {
                mapOf()
            } else {
                bag.value.split(", ").associate {
                    val (n, color) = it.groups(Regex("(\\d+) (.*) bags?"))
                    color to n.toInt()
                }
            }
        }

        return canContain("shiny gold").size
    }

    override fun part2(): Int {
        return bagsInside("shiny gold")
    }

    private fun bagsInside(bag: String): Int =
        bags[bag]?.entries?.sumOf { it.value * (1 + bagsInside(it.key)) } ?: 0

    private fun canContain(bag: String): Set<String> =
        bags.filter { it.value.containsKey(bag) }
            .keys
            .fold(setOf()) { acc, s -> acc + canContain(s) + s }
}
