package nl.chrisb.aoc21.y21

import nl.chrisb.aoc21.common.Solution

fun main() {
    Solution(2021, 13)
        .part1 {
            val parts = input.split("\n\n")
            val instructions = parts[1].lines()
            val field = Array(1500) { Array(1500) { false } }

            parts[0].lines().forEach {
                val coords = it.split(",")
                field[coords[1].toInt()][coords[0].toInt()] = true
            }

            val instr = instructions[0].split(" ")[2].split("=")
            when (instr[0]) {
                "x" -> foldX(field, instr[1].toInt())
                "y" -> foldY(field, instr[1].toInt())
            }

            field.sumOf { line -> line.count { it } }
        }
        .part2 {
            val parts = input.split("\n\n")
            val instructions = parts[1].lines()
            val field = Array(1500) { Array(1500) { false } }

            parts[0].lines().forEach {
                val coords = it.split(",")
                field[coords[1].toInt()][coords[0].toInt()] = true
            }

            instructions.forEach {
                val instr = it.split(" ")[2].split("=")
                when (instr[0]) {
                    "x" -> foldX(field, instr[1].toInt())
                    "y" -> foldY(field, instr[1].toInt())
                }
            }

            (0 until 6).forEach { y ->
                (0 until 50).forEach { x ->
                    if (field[y][x]) {
                        print("#")
                    } else {
                        print(" ")
                    }
                }

                println()
            }
        }
}

fun foldY(field: Array<Array<Boolean>>, y: Int) {
    ((y + 1) until field.size).forEach { i ->
        val index = y - (i - y)
        if (index >= 0) {
            field[index] = field[index].mapIndexed { j, it -> it || field[i][j] }.toTypedArray()
            field[i] = Array(field[i].size) { false }
        }
    }
}

fun foldX(field: Array<Array<Boolean>>, x: Int) {
    ((x + 1) until field.size).forEach { i ->
        field.forEach { line ->
            val index = x - (i - x)
            if (index >= 0) {
                line[index] = line[index] || line[i]
                line[i] = false
            }
        }
    }
}
