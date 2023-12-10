import java.math.BigInteger

private fun String.splitWhitespace() = split("\\s+".toRegex())

// s1 and s2 both have the same length
fun averageString(s1: String, s2: String, len: Int): String {
//    // Work backwards from the end
//    val avgStrChars = MutableList<Char>(len) { '?' }
//    var remainder = 0
//    for (i in len - 1 downTo 0) {
//        // Add the chars together, then divide by two
//        val c1Val = s1[i] - 'a'
//        val c2Val = s2[i] - 'a'
//        val (avgC, nextRemainder) = if (c1Val == c2Val) {
//            Pair(c1Val, 0)
//        } else if (c1Val < c2Val) {
//            Pair((c1Val + c2Val) / 2, 0)
//        } else {
//            // c1Val > c2Val
//            Pair((c1Val + c2Val + 26) / 2, -1)
//        }
//
//        avgStrChars[i] = (remainder + avgC % 26 + ('a'.code)).toChar()
//        remainder = if (c1Val + c2Val > 25) 1 else 0
//    }
//
//    return avgStrChars.joinToString("")

    var s1Num = BigInteger.ZERO
    var s2Num = BigInteger.ZERO
    for (i in 0 until len) {
        val c1Val = (s1[i] - 'a').toLong()
        val c2Val = (s2[i] - 'a').toLong()

        val placeFactor = BigInteger.valueOf(26).pow(len - i - 1)
        s1Num = s1Num.plus(BigInteger.valueOf(c1Val).times(placeFactor))
        s2Num = s2Num.plus(BigInteger.valueOf(c2Val).times(placeFactor))
    }
    val sAvg = s1Num.plus(s2Num).divide(BigInteger.valueOf(2))

    val resChars = mutableListOf<Char>()
    var rem = sAvg
    var exp = len - 1
    while (exp >= 0) {
        val divisor = BigInteger.valueOf(26).pow(exp)
        val n = rem.divide(divisor).toInt()
        rem = rem.mod(divisor)
        exp--

        val c = (n + 'a'.code).toChar()
        resChars.add(c)
    }
    return resChars.joinToString("")
}

fun main() {
    // len(s) = len(t) = k
    // k in 1..=2e5
    val k = readln().toInt()

    val s = readln()
    val t = readln()

    // Find the median string that is (> s) and (< t)
    // We know there are an odd number of such strings

    // Median will be the same as the mean
    // Treat strings like k-digit numbers in base 26.
    println(averageString(s, t, k))
}