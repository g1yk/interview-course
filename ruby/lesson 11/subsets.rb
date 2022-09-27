# https://leetcode.com/problems/subsets/

def subsets(nums)
    result = []
    subsets_impl(nums, 0, [], result)
    result
end

def subsets_impl(nums, start, current, result)
    result.push(current.clone)
    
    (start..nums.length - 1).each do |i|
        current.push(nums[i])
        subsets_impl(nums, i + 1, current, result)
        current.pop()
    end
end
