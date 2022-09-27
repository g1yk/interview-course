// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

class Solution {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        points.sortBy { it[1] }
        
        var result = 1
        var prev = points[0]
        for (i in 1..points.size-1) {
            val current = points[i]
            if (current[0] > prev[1]) {
                prev = current
                result++
            }
        }
        return result
    }
}
