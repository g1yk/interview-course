class ArrayStack
    def initialize
      	@items = []
    end

    def push(value)
      @items.push(value)
    end

    def pop()
        @items.pop
    end
end
