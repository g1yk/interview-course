// https://leetcode.com/problems/longest-increasing-subsequence/

class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> piles = new ArrayList<>();
        
        for (int num : nums) {
            int toInsert = searchInsert(piles, num);
            if (toInsert == piles.size()) {
                piles.add(num);
            } else {
                piles.set(toInsert, num);
            }
        }
        
        return piles.size();
    }
    
    private int searchInsert(List<Integer> piles, int target) {
        int lo = 0;
        int hi = piles.size() - 1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int value = piles.get(mid);
            if (value == target) {
                return mid;
            } else if (value < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return lo;
    }
}
