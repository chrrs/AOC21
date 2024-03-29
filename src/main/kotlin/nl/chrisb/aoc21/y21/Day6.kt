package nl.chrisb.aoc21.y21

import nl.chrisb.aoc21.common.Solution
import nl.chrisb.aoc21.common.toInts

fun main() {
    Solution(2021, 6)
        .part1 {
            var fish = input.split(",").toInts()
            (0 until 80).forEach { _ ->
                fish = fish
                    .map { it - 1 }
                    .flatMap { if (it == -1) listOf(6, 8) else listOf(it) }
            }
            fish.size
        }
        .part2 {
            val fish = MutableList(9) { 0L }
            input.split(",").toInts()
                .forEach { fish[it] += 1L }

            (0 until 256).forEach { _ ->
                fish.add(fish.removeAt(0))
                fish[6] += fish[8]
            }

            fish.sum()
        }
}
