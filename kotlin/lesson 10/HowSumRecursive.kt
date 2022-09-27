fun howSum(targetSum: Int, numbers: IntArray): List<Int>? {
    var dp = Array<MutableList<Int>?>(targetSum + 1, { null })
    return howSum(targetSum, numbers, dp)
}

fun howSum(targetSum: Int, numbers: IntArray, dp: Array<MutableList<Int>?>): MutableList<Int>? {
   if (targetSum < 0) return null
   if (targetSum == 0) return mutableListOf<Int>()
   if (dp[targetSum] != null) return dp[targetSum]

   for (number in numbers) {
       val current = howSum(targetSum - number, numbers, dp)
       if (current != null) {
           current.add(number)
           dp[targetSum] = current
           return dp[targetSum]
       }
   }

   return null
}
