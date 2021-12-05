package nl.chrisb.aoc21.runner

import kotlinx.serialization.Serializable

@Serializable
class Days(
    val days: MutableMap<Int, Day>
)

@Serializable
class Day(
    val input: String
)
