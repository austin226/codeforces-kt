import kotlin.test.Test
import kotlin.test.assertEquals

class FTest {
    @Test
    fun testF() {
        // 1 3 4 5 5 6 6 7 -> 1 2 3 4 5 6 7 8
        assertEquals(setOf(1, 2, 3, 4), idealUniqueWeights(listOf(3, 2, 4, 1)))
        assertEquals(setOf(1, 2, 3, 4, 5), idealUniqueWeights(listOf(1, 1, 1, 4, 4, 4)))
        assertEquals(setOf(1, 2, 3, 4, 5, 6, 7, 8), idealUniqueWeights(listOf(1, 3, 4, 5, 5, 6, 6, 7)))
        assertEquals(setOf(4), idealUniqueWeights(listOf(5)))
        assertEquals(setOf(1), idealUniqueWeights(listOf(1)))
        assertEquals(setOf(149999, 150000, 150001), idealUniqueWeights(listOf(150000, 150000, 150000)))
    }
}