function sum(nums) {
    let result = 0;
    for (let i = 0; i < nums.length; i++) {
        result += nums[i];
    }
    return result;
}

function buildMatrix(rows, cols) {      
    const result = [];
    for (let row = 0; row < rows; row++) {  
        result[row] = [];
        for (let col = 0; col < cols; col++) {  
            result[row][col] = (row + 1) * (col + 1);
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
