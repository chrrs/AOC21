package nl.chrisb.aoc21.y21

import nl.chrisb.aoc21.common.Solution
import nl.chrisb.aoc21.common.binary

fun main() {
    Solution(2021, 3)
        .part1 {
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

            gamma * epsilon
        }
        .part2 {
            var generator = lines
            var scrubber = lines
            for (bit in 0 until lines[0].length) {
                if (generator.size > 1) {
                    val count = generator.count { it[bit] == '1' }
                    val expected = if (count * 2 < generator.size) '0' else '1'
                    generator = generator.filter { it[bit] == expected }
                }

                if (scrubber.size > 1) {
                    val count = scrubber.count { it[bit] == '1' }
                    val expected = if (count * 2 < scrubber.size) '1' else '0'
                    scrubber = scrubber.filter { it[bit] == expected }
                }
            }

            generator.first().binary() * scrubber.first().binary()
        }
}
