fun howSum(targetSum: Int, numbers: IntArray): List<Int> {
    val dp = Array<Int?>(targetSum + 1, { null })
    dp[0] = 0

    for (i in 0..targetSum) {
        if (dp[i] == null) continue
        for (number in numbers) {
            if (i + number > targetSum) continue
            dp[i + number] = number
            if (i + number == targetSum) break
        }
    }

    val result = mutableListOf<Int>()
    var current = targetSum
    while (dp[current] != null && current != 0) {
        result.add(dp[current]!!)
        current = current - dp[current]!!
    }
    return result
}
