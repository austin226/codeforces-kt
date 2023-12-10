// https://codeforces.com/contest/1911/problem/H

private fun String.splitWhitespace() = split("\\s+".toRegex())

fun main() {
    val n = readln().toInt()
    val a = readln().splitWhitespace().map { it.toInt() }

    // TODO
}