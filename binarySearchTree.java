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
        
        delete(root, 5);
        inorder(root);
      
    }
}
