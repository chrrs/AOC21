package nl.chrisb.aoc21.y21

import nl.chrisb.aoc21.common.Solution
import nl.chrisb.aoc21.common.indices

fun main() {
    Solution(2021, 11)
        .part1 {
            var field = lines.map { line -> line.map { it.digitToInt() } }

            (0 until 100).sumOf { _ ->
                field = field.map { line -> line.map { (it % 10) + 1 } }
                val toFlash = field.flatMapIndexed { y, line ->
                    line.mapIndexedNotNull { x, it ->
                        if (it > 9) {
                            x to y
                        } else {
                            null
                        }
                    }
                }.toMutableList()

                while (toFlash.isNotEmpty()) {
                    field = flash(toFlash, field)
                }

                field.sumOf { line -> line.count { it > 9 } }
            }
        }
        .part2 {
            var field = lines.map { line -> line.map { it.digitToInt() } }

            indices().indexOfFirst { _ ->
                field = field.map { line -> line.map { (it % 10) + 1 } }
                val toFlash = field.flatMapIndexed { y, line ->
                    line.mapIndexedNotNull { x, it ->
                        if (it > 9) {
                            x to y
                        } else {
                            null
                        }
                    }
                }.toMutableList()

                while (toFlash.isNotEmpty()) {
                    field = flash(toFlash, field)
                }

                field.all { line -> line.all { it > 9 } }
            } + 1
        }
}

fun flash(toFlash: MutableList<Pair<Int, Int>>, field: List<List<Int>>): List<List<Int>> {
    val out = field.map { it.toMutableList() }
    val newFlash = mutableListOf<Pair<Int, Int>>()

    for ((x, y) in toFlash) {
        for ((dx, dy) in listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1, -1 to -1, 1 to -1, -1 to 1, 1 to 1)) {
            if (out.indices.contains(y + dy) && out[y].indices.contains(x + dx)) {
                if (out[y + dy][x + dx] <= 9) {
                    if (out[y + dy][x + dx] == 9) {
                        newFlash.add((x + dx) to (y + dy))
                    }

                    out[y + dy][x + dx] += 1
                }
            }
        }
    }

    toFlash.clear()
    toFlash.addAll(newFlash)
    return out
}
