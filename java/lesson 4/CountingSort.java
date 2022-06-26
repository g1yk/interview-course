public class CountingSort {
    void countingSort(int[] nums, int max) {
        int[] freq = new int[max + 1];
        for (int num : nums) {
            freq[num]++;
        }
        
        int current = 0;
        for (int i = 0; i < freq.length; i++) {
            for (int count = 0; count < freq[i]; count++) {
                nums[current] = i;
                current++;
            }
        }
    }    
}
