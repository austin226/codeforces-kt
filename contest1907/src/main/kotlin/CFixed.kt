import kotlin.streams.toList

// https://codeforces.com/contest/1907/problem/C
private fun readInt(): Int = readln().toInt()
private fun <T> List<T>.counts(): Map<T, Int> = this.groupingBy { it }.eachCount()
private fun solve(n: Int, s: String): Int {
    // https://codeforces.com/blog/entry/123012

    // The final string will always have all of the same characters.
    // If a character appears more than n/2 times, the final string will consist only of that character.
    val charCounts = s.chars().toList().counts().toMutableMap()
    var dominantChar: Int? = null
    var dominantCharCount: Int? = null
    for (charCount in charCounts) {
        if (charCount.value > n / 2) {
            // One char dominates
            dominantChar = charCount.key
            dominantCharCount = charCount.value
            break
        }
    }
    if (dominantChar == null || dominantCharCount == null) {
        // No character dominates - all pairs can be deleted
        return n % 2
    }

    charCounts.remove(dominantChar)
    return dominantCharCount - charCounts.values.sum()
}

private fun testcase() {
    val n = readInt()
    val s = readln()
    val min = solve(n, s)
    println(min)
}

fun main() {
//    val min = solve(20000, "abacd".repeat(20000 / 5))
//    val min = solve(2000, "aaacd".repeat(2000 / 5))
//    println(min)
//    return
    val t = readInt()
    for (i in 0..<t) {
        testcase()
    }
}