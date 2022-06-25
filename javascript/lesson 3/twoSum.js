function twoSum(nums, target) {
    const map = new Map();
    for (let i = 0; i < nums.length; i++) {
        const diff = target - nums[i];
        if (map.get(diff) != null) return [map.get(diff), i];
        map.set(nums[i], i);
    }
}
