// https://codeforces.com/contest/1911/problem/A

private fun readStr() = readln() // string line
private fun readInt() = readStr().toInt() // single int
private fun String.splitWhitespace() = split("\\s+".toRegex())
private fun findSpyIndex(lineNums: List<Int>, arrLen: Int): Int {
    var first: Int? = null
    var second: Int? = null
    for (i in 0 until arrLen) {
        val ai = lineNums[i]
        if (first == null) {
            first = ai
            continue
        }
        if (second == null) {
            second = ai
            continue
        }

        if (first != second) {
            return if (ai == first) 1 else 0
        }

        // first and second are equal. Return first i where ai != first
        if (ai != first) {
            return i
        }
    }
    return -1
}

fun main() {
    val nTestCases = readln().toInt()
    val spyIndexes = MutableList<Int>(nTestCases) { -1 }
    for (ti in 0 until nTestCases) {
        val arrLen = readln().toInt()
        val line = readln()
        val lineNums = line.splitWhitespace().map { it.toInt() }
        spyIndexes[ti] = findSpyIndex(lineNums, arrLen) + 1
    }
    for (i in spyIndexes) {
        println(i)
    }
}