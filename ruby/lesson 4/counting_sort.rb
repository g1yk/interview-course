def counting_sort(nums, max)
    freq = Array.new(max + 1, 0)
    nums.each { |num| freq[num] += 1 }

    current = 0
    for i in 0..freq.size - 1
        for count in 0..freq[i] - 1
            nums[current] = i
            current += 1
        end
    end
end
