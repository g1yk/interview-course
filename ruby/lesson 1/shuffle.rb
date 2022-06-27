# https://leetcode.com/problems/shuffle-an-array/

def shuffle(values)
    (0...values.length).each do |i|
        r = rand(0...i + 1)
        values[i], values[r] = values[r], values[i]
    end
end
