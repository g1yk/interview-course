def sum(nums)
    result = 0
    (0..nums.length - 1).each { |i| result += nums[i] }
    result
end

def count_zero_sum_not_optimized(nums)
    result = 0
    (0..nums.length - 1).each do |i| 
        (i + 1..nums.length - 1).each do |j|
            result += 1 if nums[i] + nums[j] == 0
        end        
    end
    result
end

def sum_recursive(nums)
    sum_recursive_impl(nums, 0);
end

def sum_recursive_impl(nums, current)
     return 0 if current >= nums.length

    nums[current] + sum_recursive_impl(nums, current + 1)
end
