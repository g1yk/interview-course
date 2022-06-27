# https://leetcode.com/problems/kth-largest-element-in-an-array/

def find_kth_largest(nums, k)
    shuffle(nums)
    find = nums.length - k
    lo = 0
    hi = nums.length - 1
    while lo < hi
        pivot = partition(nums, lo, hi)
        if pivot > find
            hi = pivot - 1
        elsif pivot < find
            lo = pivot + 1
        else
            break
        end
    end
    nums[find]
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
