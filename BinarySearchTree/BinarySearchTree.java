package BinarySearchTree;


//useing while loop which is best... 
// no recursion

public class BinarySearchTree {
    
    Node root;

    class Node
    {

        int value;
        Node right;
        Node left;
        Node(int value)
        {
            this.value = value;
        }
    }

    public boolean insert(int value)
    {
        Node newNode = new Node(value);
        if(root == null)
        {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if(temp.value == newNode.value) return false;
            if(newNode.value < temp.value)
            {
                if(temp.left == null)
                {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            }
            else
            {
                if(temp.right == null)
                {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value)
    {
        if(root == null)  return false;
        Node temp = root;
        while(temp != null)
        {
            if(temp.value == value) return true;
            else if(value > temp.value)
            temp = temp.right;
            else
            temp = temp.left;
        }
        return false;
    }
}
