package nl.chrisb.aoc21.common

import kotlinx.serialization.Serializable

@Serializable
class Cache(
    val days: MutableMap<Int, Day>
)

@Serializable
class Day(
    val input: String
)
