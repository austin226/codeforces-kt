// https://codeforces.com/contest/1911/problem/F

private fun String.splitWhitespace() = split("\\s+".toRegex())
private fun <T> List<T>.counts(): Map<T, Int> = this.groupingBy { it }.eachCount()


fun idealUniqueWeights(weights: List<Int>): Set<Int> {
    val uniqueWeights = mutableSetOf<Int>()
    for (weight in weights.sorted()) {
        if (weight > 1) {
            // First try to insert weight-1
            if (!uniqueWeights.contains(weight - 1)) {
                uniqueWeights.add(weight - 1)
                continue
            }
        }
        // Next try to insert weight
        if (!uniqueWeights.contains(weight)) {
            uniqueWeights.add(weight)
            continue
        }
        // Finally try to insert weight+1
        if (!uniqueWeights.contains(weight + 1)) {
            uniqueWeights.add(weight + 1)
        }
    }
    return uniqueWeights
}

fun main() {
    // n boxers. n in 1..=150_000
    val n = readln().toInt()

    // weight of each boxer.
    // n ints, a_i where a_i in 1..150_000
    val a = readln().splitWhitespace().map { it.toInt() }

    println(idealUniqueWeights(a).size)
}
