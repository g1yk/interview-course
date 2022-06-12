public class LinkedListStack<T> implements Stack<T> {
    private Node<T> head = null;

    public void push(T value) {        
        head = new Node<>(value, head);
    }
    
    public T pop() {
        T result = head.value;
        head = head.next;
        return result;
    }
}
