import kotlin.test.Test
import kotlin.test.assertEquals

class eTest {
    @Test
    fun testGreatestPowerUpTo() {
        assertEquals(null, greatestPowerUpTo(-1))
        assertEquals(null, greatestPowerUpTo(0))
        assertEquals(1, greatestPowerUpTo(1))
        assertEquals(2, greatestPowerUpTo(2))
        assertEquals(16, greatestPowerUpTo(21))
    }

    @Test
    fun testAsPower2Sum() {
        assertEquals(listOf(1, 2, 2, 4), asPower2Sum(9, 4))
        assertEquals(listOf(8), asPower2Sum(8, 1))
        assertEquals(null, asPower2Sum(5, 1))
        assertEquals(null, asPower2Sum(3, 7))

        assertEquals(null, asPower2Sum(7, 2))
        assertEquals(listOf(1, 4), asPower2Sum(5, 2))
        assertEquals(listOf(1, 2), asPower2Sum(3, 2))
    }
}