package nl.chrisb.aoc21.common

abstract class Solution(val year: Int, val day: Int, val title: String, val finished: Boolean = true) {
    var input: String = ""
    val lines: List<String>
        get() = input.lines()

    open fun setup() {}
    abstract fun part1(): Any?
    abstract fun part2(): Any?
}
