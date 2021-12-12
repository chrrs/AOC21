package nl.chrisb.aoc21.y21

import nl.chrisb.aoc21.common.Solution

fun main() {
    Solution(2021, 12)
        .part1 {
            val connections = mutableMapOf<String, MutableList<String>>()

            lines.forEach {
                val parts = it.split("-")
                connections.getOrPut(parts[0]) { mutableListOf() }.add(parts[1])
                connections.getOrPut(parts[1]) { mutableListOf() }.add(parts[0])
            }

            findPaths(connections, visited = setOf("start"), "start").size
        }
        .part2 {
            val connections = mutableMapOf<String, MutableList<String>>()

            lines.forEach {
                val parts = it.split("-")
                connections.getOrPut(parts[0]) { mutableListOf() }.add(parts[1])
                connections.getOrPut(parts[1]) { mutableListOf() }.add(parts[0])
            }

            findPathsTwice(connections, visited = setOf("start"), "start", false).size
        }
}

fun findPaths(connections: Map<String, List<String>>, visited: Set<String>, loc: String): Set<List<String>> {
    if (loc == "end") {
        return setOf(listOf(loc))
    }

    val out = mutableSetOf<List<String>>()
    connections[loc]?.forEach { neighbor ->
        if (neighbor.lowercase() == neighbor && visited.contains(neighbor)) {
            return@forEach
        }

        out.addAll(findPaths(connections, visited + setOf(loc), neighbor)
            .map { listOf(loc) + it })
    }

    return out
}

fun findPathsTwice(
    connections: Map<String, List<String>>,
    visited: Set<String>,
    loc: String,
    twice: Boolean
): Set<List<String>> {
    if (loc == "end") {
        return setOf(listOf(loc))
    }

    val out = mutableSetOf<List<String>>()
    connections[loc]?.forEach { neighbor ->
        if (neighbor.lowercase() == neighbor && visited.contains(neighbor)) {
            if (!twice && neighbor != "start") {
                out.addAll(findPathsTwice(connections, visited + setOf(loc), neighbor, true)
                    .map { listOf(loc) + it })
            }

            return@forEach
        }

        out.addAll(findPathsTwice(connections, visited + setOf(loc), neighbor, twice)
            .map { listOf(loc) + it })
    }

    return out
}
