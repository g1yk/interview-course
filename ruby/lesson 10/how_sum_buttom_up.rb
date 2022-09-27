def how_sum(target_sum, numbers)
    dp = Array.new(target_sum + 1)
    dp[0] = 0
    
    (0..target_sum).each do |i| 
        next if dp[i].nil?
        numbers.each do |number|
            next if i + number > target_sum
            dp[i + number] = number
            break if i + number == target_sum
        end
    end
    
    result = []
    current = target_sum
    while !dp[current].nil? && !current.zero?
        result.push(dp[current])
        current -= dp[current]
    end
    result
end
