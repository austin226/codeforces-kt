import kotlin.math.min

// https://codeforces.com/contest/1907/problem/C
private fun readInt(): Int = readln().toInt()

private fun solve(n: Int, s: String): Int {
    var min = n
    val checked = mutableSetOf(s)
    val q = ArrayDeque<String>()
    q.addFirst(s)
    while (q.isNotEmpty()) {
        val str = q.removeFirst()
        for (i in 0..<str.length - 1) {
            if (str[i] == str[i + 1]) {
                continue
            }

            // Remove i and i+1
            val newStrBuilder = StringBuilder()
            for (j in str.indices) {
                if (i != j && i + 1 != j) {
                    newStrBuilder.append(str[j])
                }
            }
            val newStr = newStrBuilder.toString()
            if (checked.contains(newStr)) {
                continue
            }

            min = min(newStr.length, min)
            if (min == 0) {
                break
            }

            q.addLast(newStr)
            checked.add(newStr)
            println("Check $newStr")
        }
    }

    return min
}

private fun testcase() {
    val n = readInt()
    val s = readln()
    val min = solve(n, s)
    println(min)
}

fun main() {
//    val min = solve(20000, "abacd".repeat(20000 / 5))
    val min = solve(2000, "abacd".repeat(2000 / 5))
    println(min)
    return
    val t = readInt()
    for (i in 0..<t) {
        testcase()
    }
}