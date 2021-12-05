package nl.chrisb.aoc21.runner

import nl.chrisb.aoc21.y21.Day1

fun main() {
    val day = Day1()
    day.input = """
        199
        200
        208
        210
        200
        207
        240
        269
        260
        263
    """.trimIndent()
    day.setup()
    println("${day.year} day ${day.day}: ${day.title} (finished: ${day.finished})")
    println(day.part1())
    println(day.part2())
}
