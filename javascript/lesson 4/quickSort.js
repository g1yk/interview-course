// https://leetcode.com/problems/sort-an-array/

function sortArray(nums) {
    quickSort(nums);
    return nums;
}

function quickSort(nums) {
    shuffle(nums);
    sort(nums, 0, nums.length - 1);
}

function sort(nums, lo, hi) {
    if (lo >= hi) return;
    const pivot = partition(nums, lo, hi);
    sort(nums, lo, pivot - 1);
    sort(nums, pivot + 1, hi);
}

function partition(nums, lo, hi) {
    const pivot = nums[lo];
    let i = lo;
    let j = hi + 1;
    while (true) {
        while (nums[++i] < pivot && i < hi);
        while (nums[--j] > pivot && j > lo);
        if (i >= j) break;
        swap(nums, i, j);
    }
    swap(nums, lo, j);
    return j;
}

function swap(nums, a, b) {
    [nums[a], nums[b]] = [nums[b], nums[a]];
}

function shuffle(nums) {
    for (let i = 0; i < nums.length; i++) {
        const r = Math.floor(Math.random() * (i + 1));
        swap(nums, i, r);
    }    
}
