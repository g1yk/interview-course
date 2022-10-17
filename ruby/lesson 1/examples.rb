def sum(nums)
    result = 0
    (0..nums.length - 1).each { |i| result += nums[i] }
    result
end

def build_matrix(rows, cols)
    result = Array.new(rows)
    (0..rows - 1).each do |row|
        result[row] = Array.new(cols)
        (0..cols - 1).each do |col|
            result[row][col] = (row + 1) * (col + 1)
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
