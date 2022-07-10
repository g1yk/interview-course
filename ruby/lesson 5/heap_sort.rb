# https://leetcode.com/problems/sort-an-array/

def sort_array(nums)
    n = nums.length
    for i in (n / 2).downto(1)
        sink(nums, i, n)
    end

    while n > 1
        swap(nums, 1, n)
        n -= 1
        sink(nums, 1, n)
    end

    nums
end

def sink(nums, k, count)
    while 2 * k <= count
        j = 2 * k
        j += 1 if j < count && less(nums, j, j + 1)
        break if not less(nums, k, j)

        swap(nums, k, j)
        k = j
    end
end

def swap(nums, i, j)
    nums[i - 1], nums[j - 1] = nums[j - 1], nums[i - 1]
end

def less(nums, i, j)
    nums[i - 1] < nums[j - 1]
end
