# https://leetcode.com/problems/subarray-sum-equals-k/
def subarray_sum(nums, k)
    sums = { 0 => 1 }
    result = sum = 0
    nums.each do |num|
        sum += num
        result += sums.fetch(sum - k, 0)
        sums[sum] = sums.fetch(sum, 0) + 1
    end
    result
end
