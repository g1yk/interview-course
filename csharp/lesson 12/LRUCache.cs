// https://leetcode.com/problems/lru-cache/

public class LRUCache
{
    private IDictionary<int, Node> map = new Dictionary<int, Node>();
    private DoubleLinkedList list = new DoubleLinkedList();
    private int capacity = 0;

    public LRUCache(int capacity)
    {
        this.capacity = capacity;
    }

    public int Get(int key)
    {
        if (map.ContainsKey(key))
        {
            var node = map[key];
            list.MoveToHead (node);
            return node.val;
        }
        return -1;
    }

    public void Put(int key, int value)
    {
        if (map.ContainsKey(key))
        {
            var node = map[key];
            node.val = value;
            list.MoveToHead(node);
        }
        else
        {
            var node = new Node(key, value);
            map[key] = node;
            list.AddToHead (node);
            if (map.Count > this.capacity)
            {
                var r = list.RemoveFromTail();
                map.Remove(r.key);
            }
        }
    }

    class DoubleLinkedList
    {
        Node head;
        Node tail;

        public DoubleLinkedList()
        {
            head = new Node();
            tail = new Node();
            head.prev = tail;
            tail.next = head;
        }

        public Node AddToHead(Node node)
        {
            Node prev = head.prev;
            prev.next = node;
            node.prev = prev;
            node.next = head;
            head.prev = node;
            return node;
        }

        public void MoveToHead(Node node)
        {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            AddToHead (node);
        }

        public Node RemoveFromTail()
        {
            Node result = tail.next;
            tail.next = result.next;
            result.next.prev = tail;
            result.prev = null;
            result.next = null;
            return result;
        }
    }

    class Node
    {
        public int key;
        public int val;
        public Node prev;
        public Node next;
        public Node() {}

        public Node(int key, int val)
        {
            this.key = key;
            this.val = val;
        }
    }
}
