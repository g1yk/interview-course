// https://leetcode.com/problems/longest-increasing-subsequence/

function lengthOfLIS(nums) {
    const piles = [];
       
   for (let num of nums) {
       const toInsert = searchInsert(piles, num);
       if (toInsert == piles.length) {
           piles.push(num);
       } else {
           piles[toInsert] = num;
       }
   }
       
   return piles.length;
}
   
function searchInsert(piles, target) {
   let lo = 0;
   let hi = piles.length - 1;

   while (lo <= hi) {
       const mid = lo + ((hi - lo) >> 1);
       const value = piles[mid];
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
