class Solution {    
    public void Shuffle(int[] values) {
        for (int i = 0; i < values.Length; i++) {
            int r = random.Next(i + 1);
            int temp = values[i];
            values[i] = values[r];
            values[r] = temp;
        }
    }
}
