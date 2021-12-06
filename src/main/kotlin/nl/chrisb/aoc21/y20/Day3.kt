package nl.chrisb.aoc21.y20

import nl.chrisb.aoc21.common.*

fun main() {
    Solution(2020, 3)
        .part1 {
            trees(3, 1)
        }
        .part2 {
            listOf(
                trees(1, 1),
                trees(3, 1),
                trees(5, 1),
                trees(7, 1),
                trees(1, 2),
            ).product()
        }
}

fun Solution.trees(right: Int, down: Int) =
    lines
        .filterIndexed { y, _ -> y % down == 0 }
        .countIndexed { y, x -> x.rollingAt(y * right) == '#' }
