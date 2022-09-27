// https://leetcode.com/problems/subsets/

function subsets(nums) {
    const result = [];
    subsetsImpl(nums, 0, [], result);
    return result;
}

function subsetsImpl(nums, start, current, result) {
    result.push([...current]);
        
    for (let i = start; i < nums.length; i++) {
        current.push(nums[i]);
        subsetsImpl(nums, i + 1, current, result);
        current.pop();
    }
}
