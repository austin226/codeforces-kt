import kotlin.test.Test
import kotlin.test.assertEquals

class HTest {
    @Test
    fun test_findIncrSeqMembers() {
        assertEquals(
            listOf(0), findIncrSeqMembers(listOf(16), 1)
        )
        assertEquals(
            listOf(0, 0), findIncrSeqMembers(listOf(10, 11), 2)
        )
        assertEquals(
            listOf(1, 0), findIncrSeqMembers(listOf(10, 1), 2)
        )
        assertEquals(
            null, findIncrSeqMembers(listOf(1, 2, 4, 0, 2), 5)
        )
        assertEquals(
            listOf(1, 0, 0, 0, 0, 1, 0, 1, 0), findIncrSeqMembers(listOf(5, 1, 3, 6, 8, 2, 9, 0, 10), 9)
        )
    }
}