package nl.chrisb.aoc21.y21

import nl.chrisb.aoc21.common.Solution
import nl.chrisb.aoc21.common.product

fun main() {
    Solution(2021, 9)
        .part1 {
            val field = lines.map { line -> line.map { it.digitToInt() } }

            field.withIndex().sumOf { (y, line) ->
                line.withIndex().sumOf { (x, a) ->
                    val ret = if (field.getOrNull(y - 1)?.getOrNull(x)?.let { it <= a } == true) {
                        0
                    } else if (field.getOrNull(y + 1)?.getOrNull(x)?.let { it <= a } == true) {
                        0
                    } else if (field.getOrNull(y)?.getOrNull(x - 1)?.let { it <= a } == true) {
                        0
                    } else if (field.getOrNull(y)?.getOrNull(x + 1)?.let { it <= a } == true) {
                        0
                    } else {
                        1 + a
                    }

                    ret
                }
            }
        }
        .part2 {
            val field = lines.map { line -> line.map { it.digitToInt() } }

            field.withIndex().flatMap { (y, line) ->
                line.withIndex().mapNotNull { (x, a) ->
                    if (field.getOrNull(y - 1)?.getOrNull(x)?.let { it <= a } == true) {
                        null
                    } else if (field.getOrNull(y + 1)?.getOrNull(x)?.let { it <= a } == true) {
                        null
                    } else if (field.getOrNull(y)?.getOrNull(x - 1)?.let { it <= a } == true) {
                        null
                    } else if (field.getOrNull(y)?.getOrNull(x + 1)?.let { it <= a } == true) {
                        null
                    } else {
                        flood(mutableListOf(), field, x, y)
                    }
                }
            }.sortedDescending().take(3).product()
        }
}

fun Solution.flood(visited: MutableList<Pair<Int, Int>>, field: List<List<Int>>, x: Int, y: Int): Int {
    if (y < 0 || y > field.size || x < 0 || x > field[y].size) {
        return 0
    }

    visited.add(x to y)

    var size = 1
    for ((offsetX, offsetY) in listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)) {
        val toCoord = (x + offsetX) to (y + offsetY)
        if (visited.contains(toCoord)) {
            continue
        }

        val to = field.getOrNull(toCoord.second)?.getOrNull(toCoord.first) ?: continue
        if (to == 9) {
            continue
        }

        size += flood(visited, field, toCoord.first, toCoord.second)
    }

    return size
}
