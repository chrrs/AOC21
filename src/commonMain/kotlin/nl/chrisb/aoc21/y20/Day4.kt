package nl.chrisb.aoc21.y20

import nl.chrisb.aoc21.common.Solution
import nl.chrisb.aoc21.common.print
import nl.chrisb.aoc21.common.splitAt

fun main() {
    Solution(2020, 4)
        .part1 {
            lines.joinToString("\n").split("\n\n").count {
                listOf("byr:", "iyr:", "eyr:", "hgt:", "hcl:", "ecl:", "pid:")
                    .all { requirement ->
                        it.contains(requirement)
                    }
            }
        }
        .part2 {
            val requirements = mapOf<String, (String) -> Boolean>(
                "byr" to { (1920..2002).contains(it.toInt()) },
                "iyr" to { (2010..2020).contains(it.toInt()) },
                "eyr" to { (2020..2030).contains(it.toInt()) },
                "hgt" to {
                    val (n, suffix) = it.splitAt(it.length - 2)
                    when (suffix) {
                        "cm" -> (150..193).contains(n.toInt())
                        "in" -> (59..76).contains(n.toInt())
                        else -> false
                    }
                },
                "hcl" to { it.matches(Regex("#[0-9a-f]{6}")) },
                "ecl" to { listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(it) },
                "pid" to { it.matches(Regex("\\d{9}")) }
            )

            lines.joinToString("\n").split("\n\n").count { line ->
                val parts = line.split(Regex("[\\n ]"))
                    .map { it.split(":") }
                    .associate { it[0] to it[1] }

                requirements.all { requirement ->
                    parts[requirement.key]?.let {
                        requirement.value(it)
                    } ?: false
                }
            }
        }
}
