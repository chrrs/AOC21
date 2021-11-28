package nl.chrisb.aoc21.common

fun List<*>.rollingAt(i: Int) = this[i % size]
fun Array<*>.rollingAt(i: Int) = this[i % size]
fun String.rollingAt(i: Int) = this[i % length]

fun String.occurrences(c: Char) = count { it == c }
fun String.binary() = Integer.parseInt(this, 2)
fun String.groups(regex: Regex) = regex.matchEntire(this)?.destructured!!
fun String.splitAt(i: Int) = this.substring(0, i) to this.substring(i)
fun String.replacingRegex(rules: Map<Regex, String>): String {
    var ret = this

    rules.forEach { (rule, with) -> ret = ret.replace(rule, with) }

    return ret
}

fun String.frequency(): Map<Char, Int> {
    val map = mutableMapOf<Char, Int>()

    forEach {
        map[it] = map.getOrDefault(it, 0) + 1
    }

    return map
}

fun List<String>.toInts() = map { it.toInt() }

operator fun CharSequence.set(index: Int, c: Char) = replaceRange(index..index, c.toString())
operator fun String.set(index: Int, c: Char) = replaceRange(index..index, c.toString())

fun Collection<Int>.product() = fold(1) { acc, i -> acc * i }

fun Collection<*>.listEquals(other: Collection<*>) = containsAll(other) && other.containsAll(this)
fun <T> Collection<T>.countIndexed(predicate: (Int, T) -> Boolean) = withIndex().count { (i, x) -> predicate(i, x) }
fun <T> Collection<T>.cartesian() = flatMap { a -> map { b -> listOf(a, b) } }
fun <T> Collection<T>.cartesian(other: Collection<T>, vararg others: Collection<T>) =
    listOf(this, other, *others)
        .fold(listOf(listOf<T>())) { acc, set -> acc.flatMap { list -> set.map { list + it } } }

fun <T> Collection<Collection<T>>.overallIntersection() = drop(1).fold(this.first()) { acc, s -> acc.intersect(s) }
fun <T> Collection<T>.frequency(): Map<T, Int> {
    val map = mutableMapOf<T, Int>()

    forEach {
        map[it] = map.getOrDefault(it, 0) + 1
    }

    return map
}

fun ByteArray.hex() = joinToString("") { "%02x".format(it) }

fun indices(from: Int = 0) = generateSequence(from) { it + 1 }

fun <T> T.print() = also { println(it) }
