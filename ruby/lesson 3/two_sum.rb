def two_sum(nums, target)
    map = {}
    nums.each_with_index do |x, i|
        diff = target - x
        return [map[diff], i] if map.include?(diff) 
        map[x] = i
    end
end
