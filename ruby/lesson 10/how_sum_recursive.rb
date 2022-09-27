def how_sum(target_sum, numbers)
    how_sum_impl(target_sum, numbers, Array.new(target_sum + 1))
end

def how_sum_impl(target_sum, numbers, dp)
    return nil if target_sum.negative?
    return [] if target_sum.zero?
    return dp[target_sum] unless dp[target_sum].nil?
    
    numbers.each do |number|
        current = how_sum_impl(target_sum - number, numbers, dp)
        unless current.nil?
            current.push(number)
            dp[target_sum] = current
            return dp[target_sum]
        end
    end
    
    nil
end
