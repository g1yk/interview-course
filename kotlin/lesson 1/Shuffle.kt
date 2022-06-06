class Solution {
    fun shuffle(values: IntArray) {
        for (i in values.indices) {
            val r = (0 until i + 1).random()
            values[i] = values[r].also { values[r] = values[i] }
        }
    }
}
