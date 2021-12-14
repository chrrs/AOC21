package nl.chrisb.aoc21.y21

import nl.chrisb.aoc21.common.Solution
import nl.chrisb.aoc21.common.frequency

fun main() {
    Solution(2021, 14)
        .part1 {
            val parts = input.split("\n\n")
            val replacements = parts[1].lines()
                .map { it.split(" -> ") }
                .associate { (it[0][0] to it[0][1]) to it[1][0] }

            var template = parts[0]
            (0 until 10).forEach { _ ->
                template = template.zipWithNext()
                    .joinToString("") {
                        replacements[it]?.let { p -> "${it.first}$p" } ?: "${it.first}"
                    } + template.last()
            }

            val frequencies = template.frequency().values
            frequencies.maxOrNull()!! - frequencies.minOrNull()!!
        }
        .part2 {
            val parts = input.split("\n\n")
            val replacements = parts[1].lines()
                .map { it.split(" -> ") }
                .associate { (it[0][0] to it[0][1]) to it[1][0] }

            var pairs = parts[0].zipWithNext().frequency().mapValues { it.value.toLong() }
            val counts = parts[0].frequency().mapValues { it.value.toLong() }.toMutableMap()
            (0 until 40).forEach { _ ->
                val newPairs = mutableMapOf<Pair<Char, Char>, Long>()
                pairs.forEach { (pair, count) ->
                    if (replacements.containsKey(pair)) {
                        val p = replacements[pair]!!
                        newPairs[pair.first to p] = (newPairs[pair.first to p] ?: 0) + count
                        newPairs[p to pair.second] = (newPairs[p to pair.second] ?: 0) + count
                        counts[p] = (counts[p] ?: 0) + count
                    } else {
                        newPairs[pair] = count
                    }
                }

                pairs = newPairs
            }

            val frequencies = counts.values
            frequencies.maxOrNull()!! - frequencies.minOrNull()!!
        }
}
