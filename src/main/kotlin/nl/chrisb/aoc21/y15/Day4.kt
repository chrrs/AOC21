package nl.chrisb.aoc21.y15

import nl.chrisb.aoc21.common.Solution
import nl.chrisb.aoc21.common.hex
import nl.chrisb.aoc21.common.indices
import java.security.MessageDigest

fun main() {
    Solution(2015, 4)
        .part1 {
            findHashKey(5)
        }
        .part2 {
            findHashKey(6)
        }
}

fun Solution.findHashKey(length: Int): Int {
    val md = MessageDigest.getInstance("MD5")
    return indices().first { i ->
        val hex = md.digest(("$input$i").toByteArray()).hex()
        hex.startsWith("0".repeat(length))
    }
}
