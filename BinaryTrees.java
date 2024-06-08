import java.util.*;

public class BinaryTrees {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    //Height of tree
    public static int height(Node root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    static class BinaryTree {
        static int idx = -1;
        public Node buildTree(int nodes[]) {
            idx++;
            if(nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    //Preorder Traversal
    public static void preOrder(Node root) {
        if(root == null) {
            //System.out.print(-1 + " ");
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //Inorder Traversal
    public static void inOrder(Node root) {
        if(root == null) {
            //System.out.print(-1 + " ");
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    //Postorder Traversal
    public static void postOrder(Node root) {
        if(root == null) {
            //System.out.print(-1 + " ");
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    //Level Order Traversal
    public static void levelOrder(Node root) {
        if(root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {
            Node curr = q.remove();
            if(curr == null) {
                System.out.println();
                //Empty queue
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(curr.data + " ");
                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }

    public static void main(String [] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("The root of the tree is " + root.data);

        System.out.println("Preorder Traversal");
        preOrder(root);
        System.out.println();

        System.out.println("Inorder Traversal");
        inOrder(root);
        System.out.println();

        System.out.println("PostOrder Traversal");
        postOrder(root);
        System.out.println();
        
        System.out.println("Level Order Traversal");
        levelOrder(root);

        System.out.println("Height of tree is " + height(root));
        System.out.println();
    }
}

//Output
// The root of the tree is 1
// Preorder Traversal
// 1 2 4 5 3 6 
// Inorder Traversal
// 4 2 5 1 3 6 
// PostOrder Traversal
// 4 5 2 6 3 1 
// Level Order Traversal
// 1 
// 2 3 
// 4 5 6 
// Height of tree is 3
