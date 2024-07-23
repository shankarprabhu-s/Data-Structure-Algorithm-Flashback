package Stack_Linked_list;

public class Stack {
    private Node top;
    private int height;
    
    class Node{
        int value;
        Node next;
        Node(int value)
        {
            this.value = value;
        }
    }

    public  Stack(int value)
    {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }
    public void display()
    {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public int getTop()
    {   if(top != null)
        return top.value;
        return -1;
    }

    public int getHeight()
    {
        return height;
    }

    public void push(int value)
    {
        Node newNode = new Node(value);
        if(height == 0 )
        {
            top = newNode;
        }
        else
        {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public int pop()
    {
        if(height == 0)
        return -1;
        int value = top.value;
        if(height == 1)
        {
            top = null;
            height--;
            return value;
        }
        top = top.next;
        height--;
        return value;

    }
}
