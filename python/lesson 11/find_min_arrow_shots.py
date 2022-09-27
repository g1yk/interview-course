# https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        points = sorted(points, key=lambda x: x[1])
        
        result = 1
        prev = points[0]
        for i in range(1, len(points)):
            current = points[i]
            if current[0] > prev[1]:
                prev = current
                result += 1
        
        return result
