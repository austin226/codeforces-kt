// https://codeforces.com/contest/1904/problem/D1

private fun String.splitWhitespace() = split("\\s+".toRegex())
private fun readInt(): Int = readln().toInt()
private fun readInts(): List<Int> = readln().splitWhitespace().map { it.toInt() }

fun canABecomeB(n: Int, a: MutableList<Int>, b: List<Int>): Boolean {
    // If any b[i] < a[a], return false
    if ((0..<n).any { i -> b[i] < a[i] }) {
        return false
    }

    for (g in 0..n) {
        for (i in 0..<n) {
            if (b[i] == g && a[i] < g) {
                // Find an l to the left
                var l = i
                while (l > 0 && a[l - 1] <= g && b[l - 1] >= g) {
                    l--
                }
                // Find r
                var r = i
                while (r < n - 1 && a[r + 1] <= g && b[r + 1] >= g) {
                    r++
                }
                if (!(l..r).any { j -> a[j] == g }) {
                    return false
                }
                for (j in l..r) {
                    a[j] = g
                }
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
