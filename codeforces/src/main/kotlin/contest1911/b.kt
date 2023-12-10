import kotlin.math.floor
import kotlin.math.sqrt

fun main() {
    val len = readln().toInt()
    val encrypted = readln()
    println(decrypt(encrypted, len))
}

fun decrypt(encrypted: String, len: Int): String {
    // Max triangular number index is floor(sqrt(2 * len))
    val m = floor(sqrt(2.0 * len)).toInt()
    val output = StringBuilder()

    var nextIdx = 0
    for (i in 0 until m) {
        output.append(encrypted[nextIdx])
        nextIdx += i + 1
    }
    return output.toString()
}