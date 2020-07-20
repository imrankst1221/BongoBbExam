## Written test for Bongo’s Android Developer position.

### Problem: 
Write a function that detects if two strings are anagram e.g. ‘bleat’ and ‘table’ are anagrams but ‘eat’ and ‘tar’ are not.  

### Solution:
Here is the funciton which take two inport and return the strings are anagram or not. 
```
fun isAnagram(inputA: String, inputB: String) : Boolean{
        val anagramMap = HashMap<Char, Int>()
        if (inputA.isEmpty() || inputA.length != inputB.length) {
            return false
        }

        for (index in inputA.indices){
            if (anagramMap.containsKey(inputA[index])) {
                anagramMap[inputA[index]] = anagramMap[inputA[index]]!! + 1
            }else{
                anagramMap[inputA[index]] = 1
            }

            if (anagramMap.containsKey(inputB[index])) {
                anagramMap[inputB[index]] = anagramMap[inputB[index]]!! - 1
            }else{
                anagramMap[inputB[index]] = - 1
            }
        }

        for ((key, value) in anagramMap){
            //print("$key $value\n")
            if (value != 0){
                return false
            }
        }
        return true
 }
```

Here is the Unit test for the **isAnagram** function.
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
