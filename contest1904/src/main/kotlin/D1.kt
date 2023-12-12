import kotlin.math.max

// https://codeforces.com/contest/1904/problem/D1

private fun String.splitWhitespace() = split("\\s+".toRegex())
private fun readInt(): Int = readln().toInt()
private fun readInts(): List<Int> = readln().splitWhitespace().map { it.toInt() }

fun canABecomeB(n: Int, a: MutableList<Int>, b: List<Int>): Boolean {
    // If any b[i] < a[a], return false
    if ((0..<n).any { i -> b[i] < a[i] }) {
        return false
    }

    for (i in 0..<n) {
        if (a[i] < b[i]) {
            // Choose l that's the last number equal to b[i]
            var l = i
            for (j in i downTo 0) {
                if (b[j] == b[i]) {
                    l = j
                }
            }

            // See if we can choose an r to the right
            // TODO - handle cases [3,2,1,1,1]->[3,3,3,2,2]
            var r = l
            var m = a[l]
            while (r < n && a[r] <= b[r] && a[r] <= b[i] && m <= b[r]) {
                m = max(m, a[r])
                r++
            }
            // set a[i] through a[r] to max
            for (j in l..<r) {
                a[j] = m
            }
        }
    }

    return a == b
}

fun main() {
    val t = readInt()
    (0..<t).forEach { _ ->
        val n = readInt()
        val a = readInts().toMutableList()
        val b = readInts()

        // operation: Choose l and r, where 1 <= l <= r <= n
        // let x = max(a[l]..a[r])
        // Set all a[l]..a[r] to max

        // Output YES if a can become b with any number of operations
        // Output NO if not
        if (canABecomeB(n, a, b)) {
            println("YES")
        } else {
            println("NO")
        }
    }
}
