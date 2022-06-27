// https://leetcode.com/problems/kth-largest-element-in-an-array/

function findKthLargest(nums, k) {
    shuffle(nums);
    const find = nums.length - k;
    let lo = 0, hi = nums.length - 1;
    while (lo < hi) {            
        var pivot = partition(nums, lo, hi);            
        if (pivot > find) hi = pivot - 1;
        else if (pivot < find) lo = pivot + 1;
        else break;
    }
    return nums[find];
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
