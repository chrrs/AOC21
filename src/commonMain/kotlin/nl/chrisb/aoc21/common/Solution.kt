package nl.chrisb.aoc21.common

abstract class Solution(val year: Int, val day: Int, val title: String, val finished: Boolean = true) {
    var input: String = ""
    val lines: List<String>
        get() = input.lines()

    abstract fun part1(): Any?
    abstract fun part2(): Any?
}

val allSolutions = listOf(
    nl.chrisb.aoc21.y15.Day1,
    nl.chrisb.aoc21.y15.Day2,
    nl.chrisb.aoc21.y15.Day3,
    nl.chrisb.aoc21.y15.Day4,
    nl.chrisb.aoc21.y15.Day5,
    nl.chrisb.aoc21.y15.Day6,
    nl.chrisb.aoc21.y15.Day7,

    nl.chrisb.aoc21.y20.Day1,
    nl.chrisb.aoc21.y20.Day2,
    nl.chrisb.aoc21.y20.Day3,
    nl.chrisb.aoc21.y20.Day4,
    nl.chrisb.aoc21.y20.Day5,
    nl.chrisb.aoc21.y20.Day6,
    nl.chrisb.aoc21.y20.Day7,
    nl.chrisb.aoc21.y20.Day8,
    nl.chrisb.aoc21.y20.Day9,

    nl.chrisb.aoc21.y21.Day1,
    nl.chrisb.aoc21.y21.Day2,
    nl.chrisb.aoc21.y21.Day3,
    nl.chrisb.aoc21.y21.Day4,
    nl.chrisb.aoc21.y21.Day5,
)
