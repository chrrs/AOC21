package nl.chrisb.aoc21.y15

import nl.chrisb.aoc21.common.Solution
import nl.chrisb.aoc21.common.hex
import nl.chrisb.aoc21.common.indices
import nl.chrisb.aoc21.common.md5

object Day4 : Solution(2015, 4, "The Ideal Stocking Stuffer") {
    override fun part1(): Int {
        return findHashKey(5)
    }

    override fun part2(): Int {
        return findHashKey(6)
    }

    private fun findHashKey(length: Int): Int {
        return indices().first { i ->
            val hex = "$input$i".encodeToByteArray().md5().hex()
            hex.startsWith("0".repeat(length))
        }
    }
}
