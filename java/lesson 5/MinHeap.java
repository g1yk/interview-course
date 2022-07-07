public class MinHeap {
    private int[] items;
    private int count;

    public MinHeap(int capacity) {
        items = new int[capacity + 1];
    }

    public int size() {
        return count;
    }

    public void add(int key) {
        count++;
        items[count] = key;
        swim(count);
    }

    public int poll() {
        int result = items[1];
        swap(1, count);
        count--;
        sink(1);
        return result;
    }

    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            swap(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= count) {
            int j = 2 * k;
            if (j < count && greater(j, j + 1))
                j++;
            if (!greater(k, j)) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    private void swap(int i, int j) {
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    private boolean greater(int i, int j) {
        return items[i] > items[j];
    }
}
