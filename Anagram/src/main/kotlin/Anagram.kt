import java.util.*
import kotlin.collections.HashMap

object Anagram {
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

    @JvmStatic
    fun main(args: Array<String>) {
        val scanner = Scanner(System.`in`)
        val inputA = scanner.nextLine()
        val inputB = scanner.nextLine()

        println("" + isAnagram(inputA, inputB))
    }
}