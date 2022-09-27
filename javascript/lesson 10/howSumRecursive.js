function howSum(targetSum, numbers) {
    return howSumImpl(targetSum, numbers, new Array(targetSum + 1));
}

function howSumImpl(targetSum, numbers, dp) {
    if (targetSum < 0) return null;
    if (targetSum == 0) return [];
    if (dp[targetSum]) return dp[targetSum];        
    
    for (let number of numbers) {
        const current = howSumImpl(targetSum - number, numbers, dp);
        if (current) {
            current.push(number);
            dp[targetSum] = current;
            return dp[targetSum];
        }
    }
    
    return null;
}
