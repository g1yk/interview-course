class Solution {   
    public static void shuffle(int[] values) {
        Random random = new Random();
        for (int i = 0; i < values.length; i++) {
            int r = random.nextInt(i + 1);
            int temp = values[i];
            values[i] = values[r];
            values[r] = temp;
        }
    }
}
