// https://codeforces.com/contest/1911/problem/H

private fun String.splitWhitespace() = split("\\s+".toRegex())
private fun <T> List<T>.counts(): Map<T, Int> = this.groupingBy { it }.eachCount()

private fun <T : Comparable<T>> List<T>.isStrictlyDecreasing(): Boolean =
    (size <= 1) || (1 until size).all { i -> get(i) < get(i - 1) }

private fun <T : Comparable<T>> List<T>.isStrictlyIncreasing(): Boolean =
    (size <= 1) || (1 until size).all { i -> get(i) > get(i - 1) }


/** Return 0 for each index whose member in a belongs to the increasing sequence.
 * 1 otherwise. null if not possible. */
fun findIncrSeqMembers(a: List<Int>, n: Int): List<Int>? {
    val res = MutableList(n) { 0 }

    var incrMax = Int.MIN_VALUE
    var decrMin = Int.MAX_VALUE
    if (n > 1 && a[0] >= a[1]) {
        res[0] = 1
        decrMin = res[0]
        // TODO extend this using a while loop. Take all decreasing numbers into decr until we hit something that has to go into incr.
        // TODO that probably won't cover many cases...
    }

    for (k in a) {
        if (k < decrMin) {
            decrMin = k
        } else if (k > incrMax) {
            incrMax = k
        } else {
            return null
        }
    }

    return res
}

fun main() {
    val n = readln().toInt()
    val a = readln().splitWhitespace().map { it.toInt() }

    // If there are >2 of any input, print NO
    findIncrSeqMembers(a, n)?.let {
        println("YES")
        println(it.joinToString(" "))
        return
    }

    println("NO")
}