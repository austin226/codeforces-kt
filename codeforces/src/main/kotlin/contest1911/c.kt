// https://codeforces.com/contest/1911/problem/C

private fun String.splitWhitespace() = split("\\s+".toRegex())

fun main() {
    // n students, 2..=100, even
    val n = readln().toInt()

    // skill of each student
    // n ints a_i, in 1..=100
    val a = readln().splitWhitespace().map { it.toInt() }

    // two students can form a team if they have equal skill.
    // each problem solved increases a skill by 1.
    // Find min number of problems solves to be able to form n/2 teams.

    // count how many of each skill there are
    val counts = mutableMapOf<Int, Int>()
    for (skill in a) {
        counts[skill] = counts.getOrDefault(skill, 0) + 1
    }

    // Remove any existing pairs
    val remainingSkills = a.filter { counts[it]!! % 2 != 0 }.sorted()
    val potentialPairs = remainingSkills.chunked(2)

    var sum = 0
    for (pair in potentialPairs) {
        sum += pair[1] - pair[0]
    }

    println(sum)
}