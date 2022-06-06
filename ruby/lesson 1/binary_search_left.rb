def binary_search_left(nums, target)
    lo = 0
    hi = nums.length - 1

    while lo <= hi
        mid = lo + (hi - lo) / 2
        next hi = mid - 1 if nums[mid] > target
        next lo = mid + 1 if nums[mid] < target
        return mid if mid.zero? || nums[mid - 1] < target
        hi = mid - 1
    end

    -1
end
