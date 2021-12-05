package nl.chrisb.aoc21.y15

import nl.chrisb.aoc21.common.Solution

object Day4 : Solution(2015, 4, "The Ideal Stocking Stuffer") {
    override fun part1(): Int {
        return findHashKey(5)
    }

    override fun part2(): Int {
        return findHashKey(6)
    }

    private fun findHashKey(length: Int): Int {
        // val md = MessageDigest.getInstance("MD5")
        // return indices().first { i ->
        //     val hex = md.digest(("$input$i").toByteArray()).hex()
        //     hex.startsWith("0".repeat(length))
        // }
        return 0 // TODO: Fix this to be multiplatform compatible.
    }
}
