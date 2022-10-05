# https://leetcode.com/problems/longest-increasing-subsequence/

def length_of_lis(nums)
    piles = []    
    nums.each do |num|
        to_insert = search_insert(piles, num)
        if to_insert == piles.length
            piles.push(num)
        else
            piles[to_insert] = num
        end
    end    
    piles.length
end

def search_insert(nums, target)
    lo = 0
    hi = nums.length - 1

    while lo <= hi
        mid = lo + (hi - lo) / 2
        next hi = mid - 1 if nums[mid] > target
        next lo = mid + 1 if nums[mid] < target
        return mid
    end

    lo
end