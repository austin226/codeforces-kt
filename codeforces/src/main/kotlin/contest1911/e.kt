import java.util.*

private fun String.splitWhitespace() = split("\\s+".toRegex())

fun greatestPowerUpTo(n: Int): Int? {
    if (n < 1) {
        return null
    }
    var p = 1
    while (p < n) {
        if (p * 2 > n) {
            return p
        }
        p *= 2
    }
    return p
}

fun asPower2Sum(n: Int, k: Int): List<Int>? {
    // First, find the smallest list of powers of 2 we can use to write n. If it's longer than k, return null.
    val powers = LinkedList<Int>()
    var remainder = n
    var powersUsed = 0
    while (remainder > 0) {
        val p = greatestPowerUpTo(remainder)!!
        remainder -= p
        powers.add(p)
        powersUsed++
        if (powersUsed > k) {
            // return null if not possible
            return null
        }
    }

    // Next, break up any powers we can until we can reach k, or we get all 1's.
    while (powers.size < k) {
        val f = powers.first
        if (f == 1) {
            // first value is a 1 - we can't reach k
            return null
        }
        powers.removeFirst()
        if (f == 2) {
            powers.add(1)
            powers.add(1)
        } else {
            powers.add(0, f / 2)
            powers.add(0, f / 2)
        }
    }
    return powers.sorted()
}

fun main() {
    // Can we write n as a sum of exactly k powers of 2?
    // n in 1..=1e9
    // k in 1..=2e5
    val (n, k) = readln().splitWhitespace().map { it.toInt() }
    asPower2Sum(n, k)?.let {
        println("YES")
        println(it.joinToString(" "))
        return
    }
    println("NO")
}
