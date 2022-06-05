function pivotIndex(nums) {
    if (nums.length == 0) return -1;
        
    const sums = [nums[0]];
    for (let i = 1; i < nums.length; i++) {
       sums[i] = sums[i - 1] + nums[i];
    }

    for (let i = 0; i < sums.length; i++) {
        const left = i == 0 ? 0 : sums[i - 1];
        const right = sums[sums.length - 1] - sums[i]; 
        if (left === right) return i;
    }

    return -1; 
}
