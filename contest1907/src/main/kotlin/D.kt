import kotlin.math.max
import kotlin.math.min

// https://codeforces.com/contest/1907/problem/D

private fun String.splitWhitespace() = split("\\s+".toRegex())
private fun readInt(): Int = readln().toInt()
private fun readInts(): List<Int> = readln().splitWhitespace().map { it.toInt() }

private fun testK(segments: List<IntRange>, k: Int): Boolean {
    var location = 0..0
    for (segment in segments) {
        // Our location becomes the intersection of this segment, with the locations we can be after
        // jumping up to k.
        val locMin = max(0, location.first - k)
        val locMax = min(1_000_000_000, location.last + k)
        location = max(locMin, segment.first)..min(locMax, segment.last)

        // If the intersection is empty, return false.
        if (location.isEmpty()) {
            return false
        }
    }

    return true
}

private fun solve(segments: List<IntRange>): Int {
    // Find smallest k where testK is true
    var kL = 0
    var kR = 1_000_000_000

    var minPassed = kR
    while (kL < kR) {
        val kM = (kL + kR) / 2
        if (testK(segments, kM)) {
            minPassed = min(minPassed, kM)
            // try smaller
            kR = kM - 1
        } else {
            // Try bigger
            kL = kM + 1
        }
    }
    if (kL == kR) {
        if (testK(segments, kL)) {
            minPassed = min(minPassed, kL)
        }
    }
    return minPassed
}

private fun testcase() {
    val n = readInt()
    val segments = MutableList(n) { 0..0 }
    for (i in 0..<n) {
        val lr = readInts()
        val l = lr[0]
        val r = lr[1]
        segments[i] = l..r
    }
    println(solve(segments))
}

fun main() {
    val t = readInt()
    for (i in 0..<t) {
        testcase()
    }
}