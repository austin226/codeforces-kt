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
}