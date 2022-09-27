# https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

def find_min_arrow_shots(points)
    points = points.sort_by(&:last)
        
    result = 1
    prev = points[0]
    (1..points.length - 1).each do |i|
        current = points[i]
        if current[0] > prev[1]
            prev = current
            result += 1
        end
    end
    result
end
