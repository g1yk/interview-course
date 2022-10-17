function sum(nums) {
    let result = 0;
    for (let i = 0; i < nums.length; i++) {
        result += nums[i];
    }
    return result;
}

function countZeroSumNotOptimized(nums) {
    let result = 0;
    for (let i = 0; i < nums.length; i++) {
        for (let j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] == 0)
                result++;
        }
    }
    return result;
}

function sumRecursive(nums) {
    return sumRecursiveImpl(nums, 0);
}

function sumRecursiveImpl(nums, current) {
    if (current >= nums.length) return 0;

    return nums[current] + sumRecursiveImpl(nums, current + 1);
}
