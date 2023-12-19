// https://codeforces.com/contest/1907/problem/A

private fun readInt(): Int = readln().toInt()

fun spaceName(row: Int, col: Int): String {
    val cChar = 'a' + col
    val rChar = '0' + row
    return "${cChar}${rChar}"
}

fun main() {
    val t = readInt()
    for (tI in 0..<t) {
        val space = readln()
        val col = space[0] - 'a'
        val row = space[1].toString().toInt()

        // Output all squares where rook can move
        for (r in 1..8) {
            if (r != row) {
                println(spaceName(r, col))
            }
        }
        for (c in 0..7) {
            if (c != col) {
                println(spaceName(row, c))
            }
        }
    }
}