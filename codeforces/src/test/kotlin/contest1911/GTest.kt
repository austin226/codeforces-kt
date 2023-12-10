import kotlin.test.Test
import kotlin.test.assertEquals


class GTest {
    @Test
    fun test_averageString() {
        assertEquals(
            "c",
            averageString("a", "e", 1)
        )
        assertEquals(
            "bc",
            averageString("az", "bf", 2)
        )
        assertEquals(
            "alvuw",
            averageString("afogk", "asdji", 5)
        )
        assertEquals(
            "qoztvz",
            averageString("nijfvj", "tvqhwp", 6)
        )
    }

    @Test
    fun test_avgString_longInputs() {
        for (len in listOf(1, 10, 100, 1000, 10000, 20000)) {
            val str1 = MutableList(len) { 'a' }.joinToString("")
            val str2 = MutableList(len) { 'e' }.joinToString("")
            val expectedAvg = MutableList(len) { 'c' }.joinToString("")
            println("Test with len=$len")
            assertEquals(expectedAvg, averageString(str1, str2, len))
        }
    }
}