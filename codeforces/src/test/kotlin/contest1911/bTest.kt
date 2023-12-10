import kotlin.test.Test
import kotlin.test.assertEquals

class bTest {
    @Test
    fun testDecrypt() {
        assertEquals(decrypt("baabbb", 6),"bab")
        assertEquals(decrypt("ooopppssss", 10), "oops")
        assertEquals(decrypt("z", 1), "z")
        assertEquals(decrypt("abbcccdddeeeeeffffff", 20), "abcdef")
    }
}