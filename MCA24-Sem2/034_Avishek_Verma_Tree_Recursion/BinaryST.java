import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinaryST {

    Node root;

    BinaryST() {
        root = null;
    }

    public Node insertIntoBST(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        } else if (data > root.data) {
            root.right = insertIntoBST(root.right, data);
        } else {
            root.left = insertIntoBST(root.left, data);
        }
        return root;
    }

    public void insert(int data) {
        root = insertIntoBST(root, data);
    }

    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void levelOrder(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.peek();
            System.out.print(temp.data + " ");
            queue.remove();

            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }

        }

    }

    public void search(int key) {
        Node temp = root;
        int flag = 0;

        if (root.data == key)
            flag = 1;

        else {
            while (temp.left != null && temp.right != null) {
                if (key > temp.data)
                    temp = temp.right;
                else
                    temp = temp.left;

                if (temp.data == key) {
                    flag = 1;
                    break;
                }
            }
        }

        if (flag == 1)
            System.out.println(key + " found !!");
        else
            System.out.println(key + " not found !!");
    }

    boolean isLeaf(Node root) {
        if (root.left == null && root.right == null)
            return true;
        return false;
    }

    public Node delete(Node root, int key) {
        if (root == null)
            return root;

        else if (root.data == key) {
            // 0 child
            if (isLeaf(root)) {
                root = null;
                return null;
            }
            // 1 child

            if (root.left != null && root.right == null) {
                Node temp = root.left;
                root = null;
                return temp;
            } else if (root.left == null && root.right != null) {
                Node temp = root.right;
                root = null;
                return temp;
            }

            // 2 children

            if (root.left != null && root.right != null) {
                // int max = maxVal(root.left);
                int min = minVal(root.right).data;
                root.data = min;
                root.right = delete(root.right, min);
                return root;
            }
        }

        else if (key < root.data) {
            // go to left part
            root.left = delete(root.left, key);
            return root;
        } else {
            // go to right part
            root.right = delete(root.right, key);
            return root;
        }
        return root;

    }

    public Node minVal(Node root) {
        Node temp = root;
        while (temp.left != null) {
            temp = temp.left;
        }

        // returning the address of the minimum value
        return temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryST binSt = new BinaryST();
        binSt.insert(100);
        binSt.insert(20);
        binSt.insert(200);
        binSt.insert(10);
        binSt.insert(30);
        binSt.insert(150);
        binSt.insert(300);

        System.out.println("Pre-Order Traversal -> ");
        binSt.preorder(binSt.root);
        System.out.println('\n');

        System.out.println("In-Order Traversal -> ");
        binSt.inorder(binSt.root);
        System.out.println('\n');

        System.out.println("Post-Order Traversal -> ");
        binSt.postorder(binSt.root);
        System.out.println('\n');

        System.out.println("Level-Order Traversal -> ");
        binSt.levelOrder(binSt.root);

        System.out.println('\n');

        System.out.println("Enter data to search: ");
        binSt.search(sc.nextInt());

        System.out.println("Enter data to delete: ");
        binSt.root = binSt.delete(binSt.root, sc.nextInt());

        System.out.println("Level-Order Traversal -> ");
        binSt.levelOrder(binSt.root);

        sc.close();
    }
}
