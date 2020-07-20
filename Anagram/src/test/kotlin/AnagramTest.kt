import junit.framework.TestCase.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class AnagramTest {
    @Test
    fun testBaseCase() {
        assertTrue(Anagram.isAnagram("bleat", "table"))
        assertFalse(Anagram.isAnagram("eat", "tar"))
    }

    @Test
    fun testAnagramsTrue() {
        assertTrue(Anagram.isAnagram("a", "a"))
        assertTrue(Anagram.isAnagram("aa", "aa"))
        assertTrue(Anagram.isAnagram("AAA", "AAA"))
        assertTrue(Anagram.isAnagram("JAVA", "JAAV"))
        assertTrue(Anagram.isAnagram("JAVA", "JAVA"))
        assertTrue(Anagram.isAnagram("JAVA", "AAJV"))
        assertTrue(Anagram.isAnagram("JAVA", "AAJV"))
        assertTrue(Anagram.isAnagram("An apple", "An apple"))
        assertTrue(Anagram.isAnagram("An apple", "apple An"))
        assertTrue(Anagram.isAnagram("AAAAAAAAAAB", "BAAAAAAAAAA"))
    }

    @Test
    fun testAnagramsFalse() {
        assertFalse(Anagram.isAnagram("", ""))
        assertFalse(Anagram.isAnagram("a", "A"))
        assertFalse(Anagram.isAnagram("aa", "AA"))
        assertFalse(Anagram.isAnagram("aa", "AAA"))
        assertFalse(Anagram.isAnagram("aaa", "AaA"))
        assertFalse(Anagram.isAnagram("aAa", "AaA"))
        assertFalse(Anagram.isAnagram("aaa", "aAa"))
        assertFalse(Anagram.isAnagram("JAVA", "jAAV"))
        assertFalse(Anagram.isAnagram("JAVA", "AAJv"))
        assertFalse(Anagram.isAnagram("AAAAAAAAAAB", "BAAAAAAAA"))
        assertFalse(Anagram.isAnagram("An apple", "Anapple"))
        assertFalse(Anagram.isAnagram("An apple", "An applE"))
        assertFalse(Anagram.isAnagram("An apple", "an apple"))
    }
}