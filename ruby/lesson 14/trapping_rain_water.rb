# https://leetcode.com/problems/trapping-rain-water/

def trap(height)
    left_max = Array.new(height.length)
    left_max[0] = height[0]
    (1..height.length - 1).each { |i| left_max[i] = [height[i], left_max[i - 1]].max }

    right_max = Array.new(height.length)
    right_max[height.size - 1] = height[height.size - 1]    
    (height.length - 2).downto(0) { |i| right_max[i] = [height[i], right_max[i + 1]].max }
        
    result = 0
    (1..height.length - 1).each { |i| result = result + [left_max[i], right_max[i]].min - height[i] }
    result
end
