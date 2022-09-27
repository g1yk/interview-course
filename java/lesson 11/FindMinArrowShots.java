// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int result = 1;
        int[] prev = points[0];
        for (int i = 1; i < points.length; i++) {
            int[] current = points[i];
            if (current[0] > prev[1]) {
                prev = current;
                result++;
            }
        }
        return result;
    }
}
