function howSum(targetSum, numbers) {
    const dp = new Array(targetSum + 1);
    dp[0] = 0;

    for (let i = 0; i <= targetSum; i++) {
        if (dp[i] == null) continue;            
        for (let number of numbers) {
            if (i + number > targetSum) continue;
            dp[i + number] = number;
            if (i + number == targetSum) break;
        }
    }
    
    const result = [];
    let current = targetSum;
    while (dp[current] && current != 0) {
        result.push(dp[current]);
        current = current - dp[current];
    }
    return result;
}
