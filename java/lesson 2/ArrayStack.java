public class ArrayStack<T> implements Stack<T> {
    private final int DEFAULT_CAPACITY = 2;
    private T[] items = (T[]) new Object[DEFAULT_CAPACITY];
    private int count;

    public void push(T value) {        
        if (count == items.length) resize(items.length * 2);
        items[count] = value;
        count++;
    }

    public T pop() {
        count--;
        T result = items[count];
        items[count] = null;            
        if (count > 0 && count == items.length / 4) resize(items.length / 2);
        return result;
    }

    private void resize(int size) {
        T[] copy = (T[]) new Object[size];
        for (int i = 0; i < this.count; i++) {
            copy[i] = items[i];
        }
        items = copy;
    }
}
