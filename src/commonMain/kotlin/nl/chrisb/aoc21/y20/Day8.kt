package nl.chrisb.aoc21.y20

import nl.chrisb.aoc21.common.Solution

fun main() {
    Solution(2020, 8)
        .part1 {
            var pc = 0
            var accumulator = 0
            val visited = mutableSetOf<Int>()

            while (!visited.contains(pc)) {
                visited.add(pc)
                val parts = lines[pc].split(" ")
                val arg = parts[1].toInt()

                when (parts[0]) {
                    "nop" -> pc++
                    "acc" -> {
                        accumulator += arg
                        pc++
                    }
                    "jmp" -> pc += arg
                }
            }

            accumulator
        }
        .part2 {
            for (i in lines.indices) {
                if (lines[i].startsWith("acc")) {
                    continue
                }

                var pc = 0
                var accumulator = 0
                val visited = mutableSetOf<Int>()

                while (!visited.contains(pc)) {
                    if (pc == lines.size) {
                        return@part2 accumulator
                    }

                    visited.add(pc)
                    val parts = lines[pc].split(" ").toMutableList()
                    val arg = parts[1].toInt()

                    if (pc == i) {
                        parts[0] = if (parts[0] == "nop") "jmp" else "nop"
                    }

                    when (parts[0]) {
                        "nop" -> pc++
                        "acc" -> {
                            accumulator += arg
                            pc++
                        }
                        "jmp" -> pc += arg
                    }
                }
            }
        }
}
