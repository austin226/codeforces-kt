import kotlin.test.Test
import kotlin.test.assertEquals

class D1Test {
    @Test
    fun dTest() {
        assertEquals(
            true, canABecomeB(
                5,
                mutableListOf(1, 2, 3, 2, 4),
                listOf(1, 3, 3, 2, 4)
            )
        )
        assertEquals(
            false, canABecomeB(
                5,
                mutableListOf(3, 4, 2, 2, 4),
                listOf(3, 4, 3, 4, 4)
            )
        )
        assertEquals(
            true, canABecomeB(
                5,
                mutableListOf(3, 2, 1, 1, 1),
                listOf(3, 3, 3, 2, 2)
            )
        )
        assertEquals(
            false, canABecomeB(
                2,
                mutableListOf(1, 1),
                listOf(1, 2)
            )
        )
        assertEquals(
            false, canABecomeB(
                3,
                mutableListOf(1, 1, 2),
                listOf(2, 1, 2)
            )
        )
        assertEquals(
            true, canABecomeB(
                4,
                mutableListOf(1, 4, 3, 4),
                listOf(1, 4, 4, 4)
            )
        )
    }
}