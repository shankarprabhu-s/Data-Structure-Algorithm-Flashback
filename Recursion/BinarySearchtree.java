package Recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class BinarySearchtree {

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

    private boolean rContains(Node currentNode , int value)
    {
        if(currentNode == null) return false;
        if(currentNode.value == value) return true;
        if(value < currentNode.value) return rContains(currentNode.left, value);
        return rContains(currentNode.right, value);
    }

    private Node rInsert(Node currentNode,int value)
    {
        if(currentNode == null)
        {
            Node newNode = new Node(value);
            currentNode = newNode;
            return currentNode;
        }
        if(value < currentNode.value) 
        currentNode.left =  rInsert(currentNode.left, value);
        else if(value > currentNode.value)
        currentNode.right =  rInsert(currentNode.right, value);

        return currentNode;
    }

    public int minValue(Node currentNode)
    {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    @SuppressWarnings("unused")
    private Node deleteNode(Node currentNode,int value)
    {
     if(currentNode == null) return null;
     if(value < currentNode.value)
     currentNode.left = deleteNode(currentNode.left, value);
     else if(value > currentNode.value)
     currentNode.right = deleteNode(currentNode.right, value);
     else //value is equal
     {
            if(currentNode.left == null && currentNode.right == null)
            return null;
            else if(currentNode.left == null)
            currentNode = currentNode.right;
            else if(currentNode.right == null)
            currentNode = currentNode.left;
            else
            {
                int subTreeMin = minValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = deleteNode(currentNode.right
                , value);
            }
     }
     return currentNode;
    }
    public boolean rContains(int value)
    {
       return rContains(root, value);
    }

    public void rInsert(int value)
    {
        if(root == null)  root = new Node(value);
        rInsert(root,value);
    }


    //Tree Traversals

    //! BREADTH FIRST SEARCH' --- level order  traversal
    public ArrayList<Integer> BFS()
    {
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        queue.add(currentNode);
        while (queue.size() > 0) {
            currentNode = queue.remove();
            result.add(currentNode.value);
            if(currentNode.left != null)
            queue.add(currentNode.left);
            if(currentNode.right != null)
            queue.add(currentNode.right);
        }
        return result;
    }

    //! DEPTH FIRST SEARCH --prreorder traversal
    // root - left -right

        // Pre-order traversal method
        public ArrayList<Integer> DFSPreOrder() {
            ArrayList<Integer> results = new ArrayList<>();
            traverse(root, results);
            return results;
        }
        
        private void preOrderHelper(Node currentNode, ArrayList<Integer> results) {
            if (currentNode == null) {
                return;
            }
            results.add(currentNode.value);
            traverse(currentNode.left, results);
            traverse(currentNode.right, results);
        }
        
        // left - right - root
        public ArrayList<Integer> DFS_PostOrder() {
            ArrayList<Integer> results = new ArrayList<>();
            postOrderTraversal(root, results);
            return results;
        }
        private void postOrderTraversal(Node node, ArrayList<Integer> results) {
            if (node == null) {
                return;
            }
            postOrderTraversal(node.left, results); // Traverse the left subtree
            postOrderTraversal(node.right, results); // Traverse the right subtree
            results.add(node.value); // Visit the root
        }


        //In order traversal
       // left - root -right //wrong

       public ArrayList<Integer> DFS_InOrder() {
        ArrayList<Integer> results = new ArrayList<>();
        InOrderTraversal(root, results);
        return results;
    }
    private void InOrderTraversal(Node node, ArrayList<Integer> results) {
        if (node == null) {
            return;
        }
        InOrderTraversal(node.left, results); // Traverse the left subtree
        results.add(node.value); // Visit the root
        InOrderTraversal(node.right, results); // Traverse the right subtree
    }
}
