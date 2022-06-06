def pivot_index(nums)
    return -1 if nums.empty?

    sums = [nums[0]]
    (1..nums.length - 1).each { |i| sums[i] = sums[i - 1] + nums[i] }

    nums.each_with_index do |_, i|
        left = i.zero? ? 0 : sums[i - 1]
        right = sums[sums.length - 1] - sums[i]
        return i if left == right
    end

    -1
end

