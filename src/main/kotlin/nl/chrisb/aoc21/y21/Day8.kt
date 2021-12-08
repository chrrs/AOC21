package nl.chrisb.aoc21.y21

import nl.chrisb.aoc21.common.Solution
import nl.chrisb.aoc21.common.listEquals

fun main() {
    Solution(2021, 8)
        .part1 {
            lines
                .map { it.split(" | ")[1] }
                .sumOf { line ->
                    line.split(" ")
                        .map { it.length }
                        .count { listOf(2, 4, 3, 7).contains(it) }
                }
        }
        .part2 {
            lines.sumOf { line ->
                val parts = line.split(" | ")
                val numbers = parts[0].split(" ").map { it.toSet() }
                val mappings = mutableMapOf<Int, Set<Char>>()

                mappings[1] = numbers.find { it.size == 2 }!!
                mappings[7] = numbers.find { it.size == 3 }!!
                mappings[4] = numbers.find { it.size == 4 }!!
                mappings[8] = numbers.find { it.size == 7 }!!
                mappings[6] = numbers.find { it.size == 6 && mappings[1]!!.intersect(it).size == 1 }!!
                mappings[5] = numbers.find { it.size == 5 && mappings[6]!!.intersect(it).size == 5 }!!
                mappings[9] = numbers.find { it.size == 6 && it.containsAll(mappings[4]!!) }!!
                mappings[0] = numbers.filter { !mappings.containsValue(it) }.find { it.size == 6 }!!
                mappings[3] = numbers.filter { !mappings.containsValue(it) }.find { it.containsAll(mappings[1]!!) }!!
                mappings[2] = numbers.find { !mappings.containsValue(it) }!!

                parts[1].split(" ").map {
                    mappings.firstNotNullOf { (a, b) ->
                        if (it.toSet().listEquals(b)) {
                            a
                        } else {
                            null
                        }
                    }
                }.joinToString("").toInt()
            }
        }
}
