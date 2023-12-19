// https://codeforces.com/contest/1907/problem/B
private fun readInt(): Int = readln().toInt()

private fun testcase() {
    val line = readln()
    val lcChars = ArrayDeque<Pair<Char, Int>>()
    val ucChars = ArrayDeque<Pair<Char, Int>>()

    line.forEachIndexed { i, c ->
        when {
            (c == 'b') -> {
                if (lcChars.size > 0) {
                    lcChars.removeLast()
                }
            }

            (c == 'B') -> {
                if (ucChars.size > 0) {
                    ucChars.removeLast()
                }
            }

            (c.isLowerCase()) -> {
                lcChars.addLast(Pair(c, i))
            }

            (c.isUpperCase()) -> {
                ucChars.addLast(Pair(c, i))
            }
        }
    }

    // Merge the final string
    val out = StringBuilder()
    while (lcChars.size + ucChars.size > 0) {
        if (lcChars.size == 0) {
            out.append(ucChars.first().first)
            ucChars.removeFirst()
        } else if (ucChars.size == 0) {
            out.append(lcChars.first().first)
            lcChars.removeFirst()
        } else {
            val firstUcIdx = ucChars.first().second
            val firstLcIdx = lcChars.first().second
            if (firstLcIdx < firstUcIdx) {
                out.append(lcChars.first().first)
                lcChars.removeFirst()
            } else {
                out.append(ucChars.first().first)
                ucChars.removeFirst()
            }
        }
    }
    println(out.toString())
}

fun main() {
    val t = readInt()
    (0..<t).forEach { _ -> testcase() }
}