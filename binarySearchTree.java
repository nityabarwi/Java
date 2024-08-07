import java.util.*;
public class binarySearchTree {
  static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
        this.data = data;
        }
    }

    public static Node insert(Node root, int value) {
        if(root == null) {
            root = new Node(value);
            return root;
        }
        if(root.data > value) {
            //left subtree
            root.left = insert(root.left, value);
        }
        else {
            //right subtree
            root.right = insert(root.right, value);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    //Search Operation
    public static boolean search(Node root, int key) {
        if(root == null) {
            return false;
        }
        if(root.data > key) {
            return search(root.left, key);
        }
        else if(root.data == key) {
            return true;
        }
        else {
            return search(root.right, key);
        }
    }

  //Delete A Node
    public static Node delete(Node root, int value) {
        if(root.data > value) {
            root.left = delete(root.left, value);
        }
        else if (root.data < value) {
            root.right = delete(root.right, value);
        }
        else {                   //root.data == val
            //Case 1
            if(root.left == null && root.right == null) {
                return null;
            }
            //Case 2
            if (root.left == null) {
                return root.right;
            }
            else if(root.right == null) {
                return root.left;
            }
            //Case 3
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    //Print in Range
    public static void range(Node root, int X, int Y) {
        if(root == null) {
            return;
        }
        if(root.data >= X && root.data <= Y) {
            range(root.left, X, Y);
            System.out.print(root.data + " ");
            range(root.right, X, Y);
        }
        else if (root.data >= Y) {
            range(root.left, X, Y);
        }
        else {
            range(root.right, X, Y);
        }
    }

    public static Node inorderSuccessor(Node root) {
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    //Print paths of tree
    public static void printPath(ArrayList<Integer> path) {
        for(int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "-> ");
        }
        System.out.println();
    }

    public static void printPath2leaf(Node root, ArrayList<Integer> path) {
        if(root == null){
            return;
        }
        path.add(root.data);

        //leaf
        if(root.left == null && root.right == null) {
            printPath(path);
        } else { //non-leaf
            printPath2leaf(root.left, path);
            printPath2leaf(root.right, path);
        }
        path.remove(path.size() - 1);
    }

  
    public static void main(String[] args){
        int values[] = {5, 1, 3, 4, 2, 7};
        Node root = null;
        for(int i = 0; i < values.length; i++){
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();

        if (search(root, 1)) {
            System.out.println("Found");
        } else {
            System.out.println("Not found");
        }

        range(root, 2, 6);

        System.out.println();

        printPath2leaf(root, new ArrayList<>());
        
        delete(root, 5);
        inorder(root);
      
    }
}


//Output
// 1 2 3 5 6 7        Inorder Traversal
// Found              Search
// 2 3 5 6            Range
// 5-> 2-> 1->        Paths Of Tree
// 5-> 2-> 3-> 
// 5-> 6-> 7-> 
// 1 2 3 6 7          After Deletion
