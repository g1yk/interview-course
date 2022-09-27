from typing import List

def how_sum(target_sum: int, numbers: List[int]) -> List[int]:
    dp = [None] * (target_sum + 1)
    dp[0] = 0
    
    for i in range(0, target_sum):
        if dp[i] == None:
            continue
        for number in numbers:
            if i + number > target_sum:
                continue
            dp[i + number] = number
            if i + number == target_sum:
                break
    
    result = []
    current = target_sum
    while dp[current] != None and current != 0:
        result.append(dp[current])
        current -= dp[current]

    return result
