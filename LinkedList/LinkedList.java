package LinkedList;
/**
 * LinkedList
 */
public class LinkedList {

private Node head;
private Node tail;
private int length;
    

    class Node
    {
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }

    public LinkedList(int value)
    {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length=1;
    }

    public void display()
    {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
        System.out.println();
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
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public void prepend(int value)
    {
        Node newNode = new Node(value);
        if(length==0)
        {
            head = newNode;
            tail = newNode;
            length++;
            return;
        }
        newNode.next = head;
        head = newNode;
        length++;

    }

    public int removeLast()
    {
        if(length == 0)
        return -1;
        else if(length == 1)
        {
            int val = head.value;
            head = null;
            tail = null;
            length--;
            return val;
        }
        Node temp=head;
        Node pre = head;
        while(temp.next!=null)
        {   pre = temp;
            temp =  temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        return temp.value;

    }

    public int removeFirst()
    {
        if(length == 0)
        return -1;
        if(length == 1)
        {
            int val = head.value;
            head = null;
            tail =null;
            length--;
            return val;
        }
    int val = head.value;
    head = head.next;
    length--;
    return val;
    }

    public int getByIndex(int index)
    {
        if(index <0 || index >= length)
        return -1;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.value;
    }

    public boolean set(int index , int value)
    {
        if(index <0 || index >= length)
        return false;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
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
        Node newNode = new Node(value);
        Node temp = head;
        for (int i = 0; i < index-1; i++) {
            temp = temp.next;
        }
        newNode.next=temp.next;
        temp.next=newNode;
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
        for (int i = 0; i < index-1; i++) {
            temp = temp.next;
        }
        int value = temp.next.value;
        temp.next = temp.next.next;
        length--;
        return value;
    }

    public void reverse()
    {
        Node temp = head;
        head = tail;
        tail = temp;
        Node next = null;
        Node prev = null;
        while(temp != null)
        {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
    }
}