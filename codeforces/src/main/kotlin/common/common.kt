private fun readStr() = readln() // string line
private fun readInt() = readStr().toInt() // single int
private fun String.splitWhitespace() = split("\\s+".toRegex())