// https://leetcode.com/problems/subsets/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsets(nums, 0, new LinkedList<Integer>(), result);
        return result;
    }
    
    private void subsets(int[] nums, int start, LinkedList<Integer> current, List<List<Integer>> result) {
        result.add((LinkedList<Integer>) current.clone());
        for (int i = start; i < nums.length; i++)  {
            current.add(nums[i]);
            subsets(nums, i + 1, current, result);
            current.removeLast();
        }
    }
}
