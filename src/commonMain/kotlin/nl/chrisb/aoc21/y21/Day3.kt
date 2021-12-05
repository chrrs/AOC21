package nl.chrisb.aoc21.y21

import nl.chrisb.aoc21.common.Solution
import nl.chrisb.aoc21.common.binary

object Day3 : Solution(2021, 3, "Binary Diagnostic") {
    override fun part1(): Int {
        val bits = Array(lines[0].length) { 0 }
        val total = lines.size

        lines.forEach { line ->
            line.toCharArray()
                .map { it.digitToInt() }
                .forEachIndexed { i, c -> bits[i] += c }
        }

        val gamma = bits
            .map { if (it * 2 < total) '0' else '1' }
            .joinToString("")
            .binary()

        val epsilon = bits
            .map { if (it * 2 < total) '1' else '0' }
            .joinToString("")
            .binary()

        return gamma * epsilon
    }

    override fun part2(): Int {
        var generator = lines
        var scrubber = lines
        for (bit in 0 until lines[0].length) {
            generator = generator.filterCommonBit(bit, false)
            scrubber = scrubber.filterCommonBit(bit, true)
        }

        return generator.first().binary() * scrubber.first().binary()
    }

    private fun List<String>.filterCommonBit(bit: Int, least: Boolean): List<String> {
        return if (size > 1) {
            val count = count { it[bit] == '1' }
            val expected = if ((count * 2 < size) xor least) '0' else '1'
            filter { it[bit] == expected }
        } else {
            this
        }
    }
}
