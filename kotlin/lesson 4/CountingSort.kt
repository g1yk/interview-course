fun countingSort(nums: IntArray, max: Int) {
    val freq = IntArray(max + 1)
    for (num in nums) {
        freq[num]++
    }

    var current = 0
    for (i in 0..freq.size-1) {
        for (count in 0..freq[i]-1) {
            nums[current] = i
            current++
        }
    }
}
