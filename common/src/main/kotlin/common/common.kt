private fun String.splitWhitespace() = split("\\s+".toRegex())

private fun <T> List<T>.counts(): Map<T, Int> = this.groupingBy { it }.eachCount()
private fun <T : Comparable<T>> List<T>.isStrictlyDecreasing(): Boolean =
    (size <= 1) || (1..<size).all { i -> get(i) < get(i - 1) }

private fun <T : Comparable<T>> List<T>.isStrictlyIncreasing(): Boolean =
    (size <= 1) || (1..<size).all { i -> get(i) > get(i - 1) }