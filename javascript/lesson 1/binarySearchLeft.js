function binarySearchLeft(nums, target) {
    let lo = 0;
    let hi = nums.length - 1;

    while (lo <= hi){
        let mid = lo + Math.floor((hi - lo + 1) / 2);        
        if (nums[mid] > target) {                
            hi = mid - 1;
        } else if (nums[mid] < target) {
            lo = mid + 1;
        } else {                
            if (mid === 0 || nums[mid - 1] < target) return mid;
            hi = mid - 1;
        }
    }

    return -1;
}
