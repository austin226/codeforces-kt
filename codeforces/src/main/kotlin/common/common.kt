private fun String.splitWhitespace() = split("\\s+".toRegex())

private fun <T> List<T>.counts(): Map<T, Int> = this.groupingBy { it }.eachCount()