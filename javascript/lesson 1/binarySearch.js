// https://leetcode.com/problems/binary-search

function search(nums, target) {
    let lo = 0;
    let hi = nums.length - 1;

    while (lo <= hi) {
        const mid = lo + ((hi - lo) >> 1);
        if (target < nums[mid]) {
            hi = mid - 1
        } else if (target > nums[mid]) {
            lo = mid + 1; 
        } else {
            return mid;
        }
    }

    return -1;
}
