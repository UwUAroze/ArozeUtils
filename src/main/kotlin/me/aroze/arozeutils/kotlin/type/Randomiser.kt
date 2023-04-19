package me.aroze.arozeutils.kotlin.type

/**
 * A randomisation implementation in which duplicates/"nearby hits" are *dramatically reduced*.
 * This works by shuffling the list and then going through it in order; repeating these steps when the end is reached.
 *
 * @property list the list of values to be randomised.
 * @return The instance of this randomiser
 * @sample randomTasties
 */
class Randomiser<T: Any>(private val list: List<T>) {

    var shuffledList = list.shuffled()
    var curretIndex = 0

    fun next(): T {
        curretIndex++
        if (curretIndex >= shuffledList.size) reset()
        return shuffledList[curretIndex]
    }

    private fun reset() {
        shuffledList = shuffledList.shuffled()
        curretIndex = 0
    }

    // Sample method for KDocs.
    private fun randomTasties() {
        val tasties = listOf("cookies", "ice cream", "pizza", "chocolate", "cake", "chicken nuggies", "human")
        val randomiser = Randomiser(tasties) // Gets the randomiser instance

        for (i in 0 .. 100) {
            println(randomiser.next()) // Prints out a random tasty
        }
    }

}