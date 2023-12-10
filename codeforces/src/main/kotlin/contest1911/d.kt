import java.util.Comparator

// https://codeforces.com/contest/1911/problem/D

private fun String.splitWhitespace() = split("\\s+".toRegex())
private fun <T> List<T>.counts(): Map<T, Int> = this.groupingBy { it }.eachCount()

fun main() {
    // n in 1..=2e5
    val n = readln().toInt()

    // a_i in 0..2e5
    val a = readln().splitWhitespace().map { it.toInt() }

    // If there are >2 of any input, print NO
    val counts = a.counts()
    if (counts.values.any { it > 2}) {
        println("NO")
        return
    } else {
        println("YES")
    }

    // Create a strictly increasing sequence
    // Find any values with count of 2 and add them in here
    val inc = counts.filter { it.value == 2 }.keys.toList().sorted()
    // Print length of inc
    println(inc.size)
    // Print inc
    println(inc.joinToString(" "))

    // Create a strictly decreasing sequence
    // Just put all nums into a set then sort decreasing
    val dec = a.toSortedSet(Comparator.reverseOrder())
    // Print length of dec
    println(dec.size)
    // Print dec
    println(dec.joinToString(" "))
}