public class ArrayStack<T> : Stack<T>
{
    private const int INITIAL_CAPACITY = 2;
    private T[] items = new T[INITIAL_CAPACITY];
    private int count;

    public void Push(T value)
    {        
        if (count == items.Length) Resize(items.Length * 2);
        items[count] = value;
        count++;
    }

    public T Pop()
    {
        count--;
        T result = items[count];
        items[count] = default(T);
        if (count > 0 && count == items.Length / 4) Resize(items.Length / 2);
        return result;
    }

    private void Resize(int size) 
    {
        T[] copy = new T[size];
        for (int i = 0; i < this.count; i++)
        {
            copy[i] = items[i];
        }
        items = copy;
    }
}