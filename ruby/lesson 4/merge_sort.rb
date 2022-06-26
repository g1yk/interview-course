# https://leetcode.com/problems/sort-an-array/

def sort_array(nums)
    merge_sort(nums)
    return nums
end

def merge_sort(nums)
    sort(nums, 0, nums.length - 1, Array.new(nums.length))
end

def sort(nums, lo, hi, temp)
    return if hi <= lo
    mid = lo + (hi - lo) / 2
    sort(nums, lo, mid, temp)
    sort(nums, mid + 1, hi, temp)
    merge(nums, lo, mid, hi, temp)
end

def merge(nums, lo, mid, hi, temp)
    (lo..hi).each { |i| temp[i] = nums[i] }

    i = lo
    j = mid + 1
    for k in lo..hi
        if i > mid
            nums[k] = temp[j]
            j += 1
        elsif j > hi
            nums[k] = temp[i]
            i += 1
        elsif temp[j] < temp[i]
            nums[k] = temp[j]
            j += 1
        else
            nums[k] = temp[i]
            i += 1
        end
    end
end
