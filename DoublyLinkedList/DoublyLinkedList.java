package DoublyLinkedList;
public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node
    {
        int value;
        Node left;
        Node right;
        Node(int value)
        {
            this.value = value;
        }
    }

    public DoublyLinkedList(int value)
    {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length=1;
    }

    public void append(int value)
    {
        Node newNode = new Node(value);
        if(length == 0)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail.right = newNode;
            newNode.left = tail;
            tail = newNode;
        }
        length++;
    }

    public void prepend(int value)
    {
        Node newNode = new Node(value);
        if(length == 0)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            newNode.right = head;
            head.left = newNode;
            head = newNode;
        }
        length++;
    }

    public int removeLast()
    {
        if(length == 0) return -1;
        if(length == 1) 
        {
            int val = head.value;
            head = null;
            tail = null;
            length = 0;
            return val;
        }
        Node temp = tail;
        tail = tail.left;
        tail.right = null;
        temp.left = null;
        length--;
        return temp.value;
    }

    public int removeFirst()
    {
        if(length == 0) return -1;
        if(length == 1) 
        {
            int val = head.value;
            head = null;
            tail = null;
            length = 0;
            return val;
        }
        Node temp = head;
        head = head.right;
        head.left = null;
        temp.right = null;
        length--;
        return temp.value;
    }

    public int getByIndex(int index)
    {
        if(index <0 || index >= length)
        return -1;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.right;
        }
        return temp.value;
    }

    public boolean set(int index , int value)
    {
        if(index <0 || index >= length)
        return false;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.right;
        }
        temp.value = value;
        return true;
    }

    public boolean insert(int index,int value)
    {
        if(index <0 || index > length)
        return false;
        if(index == 0)
        {
            prepend(value);
            return true;
        }
        if(index == length)
        {
            append(value);
            return true;
        }
        Node temp = head;
        for(int i=0;i<index-1;i++)
        temp = temp.right;

        Node newNode = new Node(value);
        newNode.right = temp.right;
        temp.right.left = newNode;
        temp.right = newNode;
        newNode.left = temp;
        length++;
        return true;
    }

    public int remove(int index)
    {
        if(index <0 || index >= length)
        return -1;
        if(index == 0)
        return removeFirst();
        if(index == length-1)
        return removeLast();
        Node temp = head;
        for(int i=0;i<index-1;i++)
        {
            temp = temp.right;
        }

        int value = temp.right.value;
        temp.right = temp.right.right;
        temp.right.right.left = temp;
        length--;
        return value;

    }
}
