private fun String.splitWhitespace() = split("\\s+".toRegex())
private fun readInt(): Int = readln().toInt()
private fun readInts(): List<Int> = readln().splitWhitespace().map { it.toInt() }
private fun <T> printList(list: List<T>, separator: String = " ") {
    println(list.joinToString(" "))
}

private fun List<Int>.prefixSum(): List<Int> = scan(0) { acc, next -> acc + next }.drop(1)

private fun <T> List<T>.counts(): Map<T, Int> = this.groupingBy { it }.eachCount()
private fun <T : Comparable<T>> List<T>.isStrictlyDecreasing(): Boolean =
    (size <= 1) || (1..<size).all { i -> get(i) < get(i - 1) }

private fun <T : Comparable<T>> List<T>.isStrictlyIncreasing(): Boolean =
    (size <= 1) || (1..<size).all { i -> get(i) > get(i - 1) }