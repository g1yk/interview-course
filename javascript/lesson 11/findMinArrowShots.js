// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

function findMinArrowShots(points) {
    points = points.sort((a, b) => a[1] - b[1]);
    
    let result = 1;
    let prev = points[0];
    for (let i = 1; i < points.length; i++) {
        current = points[i];
        if (current[0] > prev[1]) {
            prev = current;
            result++;
        }
    }
    return result;
}
