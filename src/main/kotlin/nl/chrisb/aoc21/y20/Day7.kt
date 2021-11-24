package nl.chrisb.aoc21.y20

import nl.chrisb.aoc21.common.Solution
import nl.chrisb.aoc21.common.groups

fun main() {
    Solution(2020, 7)
        .part1 {
            canContain("shiny gold").size
        }
        .part2 {
            bagsInside("shiny gold")
        }
}

fun Solution.bagsInside(bag: String, bags: Map<String, Map<String, Int>> = parseBags()): Int =
    bags[bag]?.entries?.sumOf { it.value * (1 + bagsInside(it.key, bags)) } ?: 0

fun Solution.canContain(bag: String, bags: Map<String, Map<String, Int>> = parseBags()): Set<String> =
    bags.filter { it.value.containsKey(bag) }
        .keys
        .fold(setOf()) { acc, s -> acc + canContain(s, bags) + s }

fun Solution.parseBags() = lines.associate {
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
