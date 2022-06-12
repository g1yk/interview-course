class LinkedListStack
    def initialize
        @head = nil
    end

    def push(value)
        @head = Node.new(value, @head)
    end

    def pop()
        result = @head.value
        @head = @head.next
        result
    end
end
