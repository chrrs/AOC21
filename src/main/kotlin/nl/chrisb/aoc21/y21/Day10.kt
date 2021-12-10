package nl.chrisb.aoc21.y21

import nl.chrisb.aoc21.common.Solution

fun main() {
    Solution(2021, 10)
        .part1 {
            lines.sumOf { line ->
                val stack = mutableListOf<Char>()

                line.firstNotNullOfOrNull { c ->
                    when (c) {
                        '(', '[', '{', '<' -> {
                            stack.add(c)
                            null
                        }
                        ')' -> if (stack.last() == '(') stack.removeLast().let { null } else 3L
                        ']' -> if (stack.last() == '[') stack.removeLast().let { null } else 57L
                        '}' -> if (stack.last() == '{') stack.removeLast().let { null } else 1197L
                        '>' -> if (stack.last() == '<') stack.removeLast().let { null } else 25137L
                        else -> null
                    }
                } ?: 0L
            }
        }
        .part2 {
            val scores = lines.mapNotNull { line ->
                val stack = mutableListOf<Char>()

                if (line.any { c ->
                        when (c) {
                            '(', '[', '{', '<' -> {
                                stack.add(c)
                                false
                            }
                            ')' -> if (stack.last() == '(') stack.removeLast().let { false } else true
                            ']' -> if (stack.last() == '[') stack.removeLast().let { false } else true
                            '}' -> if (stack.last() == '{') stack.removeLast().let { false } else true
                            '>' -> if (stack.last() == '<') stack.removeLast().let { false } else true
                            else -> false
                        }
                    }) {
                    null
                } else {
                    stack.reversed().fold(0L) { acc, c ->
                        acc * 5 + when (c) {
                            '(' -> 1
                            '[' -> 2
                            '{' -> 3
                            '<' -> 4
                            else -> 0
                        }
                    }
                }
            }.sorted()

            scores[scores.size / 2]
        }
}
