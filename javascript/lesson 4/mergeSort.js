// https://leetcode.com/problems/sort-an-array

function sortArray(nums) {
    mergeSort(nums);
    return nums;
}

function mergeSort(nums) {
    sort(nums, 0, nums.length - 1, new Array(nums.length));
}

function sort(nums, lo, hi, temp) {
    if (hi <= lo) return;
    const mid = lo + ((hi - lo) >> 1);
    sort(nums, lo, mid, temp);
    sort(nums, mid + 1, hi, temp);
    merge(nums, lo, mid, hi, temp);
}

function merge(nums, lo, mid, hi, temp) {
    for (let i = lo; i <= hi; i++) {
        temp[i] = nums[i];
    }

    let i = lo;
    let j = mid + 1;
    for (let k = lo; k <= hi; k++) {
        if (i > mid) {
            nums[k] = temp[j];
            j++;
        } else if (j > hi) {
            nums[k] = temp[i];
            i++;
        } else if (temp[j] < temp[i]) {
            nums[k] = temp[j];
            j++;
        } else {
            nums[k] = temp[i];
            i++;
        }
    }
}
