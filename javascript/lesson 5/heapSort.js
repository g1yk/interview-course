// https://leetcode.com/problems/sort-an-array/

function sortArray(nums) {
    var n = nums.length;
    for (let i = n >> 1; i >= 1; i--) {
        sink(nums, i, n);
    }

    while (n > 1) {
        swap(nums, 1, n);
        n--;
        sink(nums, 1, n);
    }

    return nums;
}

function sink(nums, k, count) {
    while (2 * k <= count) {
        let j = 2 * k;
        if (j < count && less(nums, j, j + 1)) {
            j++;
        }
        if (!less(nums, k, j)) {
            break;
        }
        swap(nums, k, j);
        k = j;
    }
}


function swap(nums, i, j) {
    [nums[i - 1], nums[j - 1]] = [nums[j - 1], nums[i - 1]];
}

function less(nums, i, j) {
    return nums[i - 1] < nums[j - 1];
}
