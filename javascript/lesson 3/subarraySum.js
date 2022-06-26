// https://leetcode.com/problems/subarray-sum-equals-k/
function subarraySum(nums, k) {
    const sums = new Map([[0, 1]]);
    let result = 0, sum = 0;
    nums.forEach(num => {
        sum += num;
        result += sums.get(sum - k) || 0;
        sums.set(sum, (sums.get(sum) || 0) + 1);
    });
    return result;
}
