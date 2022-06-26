function countingSort(nums, max) {
    const freq = new Array(max + 1).fill(0);
    nums.forEach(num => {
        freq[num]++;
    });

    let current = 0;
    for (let i = 0; i < freq.length; i++) {
        for (let count = 0; count < freq[i]; count++) {
            nums[current] = i;
            current += 1;
        }
    }
}
