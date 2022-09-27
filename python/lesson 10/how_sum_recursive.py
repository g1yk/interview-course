from typing import List

def how_sum(target_sum: int, numbers: List[int]) -> List[int]:
    return how_sum_impl(target_sum, numbers, [None] * (target_sum + 1))

def how_sum_impl(target_sum: int, numbers: List[int], dp: List[List[int]]) -> List[int]:
    if target_sum < 0: return None
    if target_sum == 0: return [] 
    if dp[target_sum] != None: return dp[target_sum]
    
    for number in numbers:
        current = how_sum_impl(target_sum - number, numbers, dp)
        if current != None:
            current.append(number)
            dp[target_sum] = current
            return dp[target_sum]
        
    return None
