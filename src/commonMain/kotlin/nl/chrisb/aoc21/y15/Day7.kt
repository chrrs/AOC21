package nl.chrisb.aoc21.y15

import nl.chrisb.aoc21.common.Solution
import kotlin.math.pow

fun main() {
    Solution(2015, 7)
        .part1 {
            val instructions = lines.associate {
                val parts = it.split(" -> ")
                parts[1] to parts[0]
            }

            getInstructionResult(mutableMapOf(), instructions, "a")
        }
        .part2 {
            val instructions = lines.associate {
                val parts = it.split(" -> ")
                parts[1] to parts[0]
            }.toMutableMap()

            instructions["b"] = getInstructionResult(mutableMapOf(), instructions, "a").toString()
            getInstructionResult(mutableMapOf(), instructions, "a")
        }
}

fun getInstructionResult(
    cache: MutableMap<String, UShort>,
    instructions: Map<String, String>,
    variable: String
): UShort {
    if (cache.containsKey(variable)) {
        return cache[variable]!!
    }

    val instruction = instructions[variable] ?: return 0u

    val value = if (!instruction.contains(" ")) {
        instruction.toUShortOrNull() ?: getInstructionResult(cache, instructions, instruction)
    } else if (instruction.startsWith("NOT")) {
        val arg = instruction.substring(4)
        (arg.toUShortOrNull() ?: getInstructionResult(cache, instructions, arg)).inv()
    } else {
        val leftParts = instruction.split(" ")
        val a = leftParts[0].toUShortOrNull() ?: getInstructionResult(cache, instructions, leftParts[0])
        val b = leftParts[2].toUShortOrNull() ?: getInstructionResult(cache, instructions, leftParts[2])

        when (leftParts[1]) {
            "AND" -> a and b
            "OR" -> a or b
            "LSHIFT" -> (a * 2.0.pow(b.toDouble()).toUInt()).toUShort()
            "RSHIFT" -> (a / 2.0.pow(b.toDouble()).toUInt()).toUShort()
            else -> {
                println("${leftParts[1]} is an unrecognized operator")
                0u
            }
        }
    }

    cache[variable] = value
    return value
}
