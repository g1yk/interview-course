class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()

        nums.forEachIndexed { i, element -> 
            val diff = target - element
            if (map.containsKey(diff)) return intArrayOf(map.get(diff)!!, i)
            map.put(element, i)
        }

        return intArrayOf()
    }
}
