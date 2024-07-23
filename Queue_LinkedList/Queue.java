package Queue_LinkedList;

public class Queue {    
    private Node first;
    private Node last; 
    private int length;

    class Node
    {
        int value;
        Node next;
        Node(int value)
        {
            this.value = value;
        }
    }

    public Queue(int value)
    {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    public void enqueue(int value)
    {
        Node newNode = new Node(value);
        if(length == 0)
        {
            first = newNode;
            last = newNode;
        }
        last.next = newNode;
        last = newNode;
        length++;

    }

    public int dequeue()
    {
        if(length == 0 )
        return -1;
        if(length == 1)
        {
            int value = first.value;
            first = null;
            last = null;
            length--;
            return value;
        }
        int value = first.value;
        first = first.next;
        length--;
        return value;
    }
}
