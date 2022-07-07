public class MinHeap(var capacity: Int) {
    private var items = IntArray(capacity + 1)
    private var count = 0

    fun size(): Int {
        return count
    }

    fun add(key: Int) {
        count++
        items[count] = key
        swim(count)
    }

    fun poll(): Int {
        val result = items[1]
        swap(1, count)
        count--
        sink(1)
        return result
    }

    private fun swim(index: Int) {
        var k = index
        while (k > 1 && greater(k / 2, k)) {
            swap(k / 2, k)
            k = k / 2
        }
    }

    private fun sink(index: Int) {
        var k = index
        while (2 * k <= count) {
            var j = 2 * k
            if (j < count && greater(j, j + 1)) {
                j++
            }
            if (!greater(k, j)) {
                break
            }
            swap(k, j)
            k = j
        }
    }

    private fun swap(i: Int, j: Int) {
        items[i] = items[j].also { items[j] = items[i] }
    }

    private fun greater(i: Int, j: Int): Boolean {
        return items[i] > items[j]
    }
}
