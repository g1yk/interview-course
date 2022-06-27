# https://leetcode.com/problems/sort-an-array/

def sort_array(nums)
    quick_sort(nums)
    nums
end

def quick_sort(nums)
    shuffle(nums)
    sort(nums, 0, nums.length - 1)
end

def sort(nums, lo, hi)
    return if hi <= lo
    pivot = partition(nums, lo, hi)
    sort(nums, lo, pivot - 1)
    sort(nums, pivot + 1, hi)
end

def partition(nums, lo, hi)
    pivot = nums[lo]
    i = lo
    j = hi + 1
    loop do
        loop do
            i += 1
            break unless nums[i] < pivot && i < hi
        end
        loop do
            j -= 1
            break unless nums[j] > pivot && j > lo
        end
        break if i >= j
        swap(nums, i, j)
    end
    swap(nums, lo, j)
    j
end

def swap(nums, a, b)
    nums[a], nums[b] = nums[b], nums[a]
end

def shuffle(nums)
    (0...nums.length).each do |i|
        r = rand(0...i + 1)
        swap(nums, i, r)
    end
end
