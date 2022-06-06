def binary_search(nums, target)
    lo = 0
    hi = nums.length - 1

    while lo <= hi
        mid = lo + (hi - lo) / 2
        next hi = mid - 1 if nums[mid] > target
        next lo = mid + 1 if nums[mid] < target
        return mid
    end

    -1
end
