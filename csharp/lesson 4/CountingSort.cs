public class CountingSort 
{
    void CountingSort(int[] nums, int max) {
        var freq = new int[max + 1];
        foreach (var num in nums)
        {
            freq[num]++;
        }
        
        var current = 0;
        for (var i = 0; i < freq.Length; i++)
        {
            for (var count = 0; count < freq[i]; count++)
            {
                nums[current] = i;
                current++;
            }
        }
    }
}
