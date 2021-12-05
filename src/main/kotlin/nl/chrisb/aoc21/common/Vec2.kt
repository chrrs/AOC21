package nl.chrisb.aoc21.common

data class Vec2(var x: Int, var y: Int) {
    fun move(dx: Int, dy: Int) {
        x += dx
        y += dy
    }
}
