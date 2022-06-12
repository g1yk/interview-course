public class LinkedListStack<T> : Stack<T>
{
    private Node<T> head = null;

    public void Push(T value) 
    {
        head = new Node<T>(value, head);
    }

    public T Pop() 
    {
        T result = head.Value;
        head = head.Next;
        return result;
    }
}
