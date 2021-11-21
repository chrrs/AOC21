package nl.chrisb.aoc21.common

fun List<Any?>.rollingAt(i: Int): Any? = this[i % size]
fun Array<Any?>.rollingAt(i: Int): Any? = this[i % size]
fun String.rollingAt(i: Int): Char = this[i % length]

fun String.occurrences(c: Char): Int = count { it == c }
fun String.binary(): Int = Integer.parseInt(this, 2)
fun String.replacingRegex(rules: Map<String, String>): String {
    var ret = this

    rules.forEach { (rule, with) -> ret = ret.replace(Regex(rule), with) }

    return ret
}

fun List<String>.toInts(): List<Int> = map { it.toInt() }

operator fun CharSequence.set(index: Int, c: Char) = replaceRange(index..index, c.toString())
operator fun String.set(index: Int, c: Char) = replaceRange(index..index, c.toString())

fun Collection<Int>.product() = fold(1) { acc, i -> acc * i }

fun Collection<*>.listEquals(other: Collection<*>) = containsAll(other) && other.containsAll(this)
fun <T> Collection<T>.cartesian() = flatMap { a -> map { b -> listOf(a, b) } }
fun <T> Collection<T>.cartesian(other: Collection<T>, vararg others: Collection<T>) =
    listOf(this, other, *others)
        .fold(listOf(listOf<T>())) { acc, set -> acc.flatMap { list -> set.map { list + it } } }
