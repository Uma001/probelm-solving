package practice.dsPrac;


//insert in simple BST way
//if node gets unbalnced(diff between left & right child's height is <1(right heavy) or >1(left heavy)) perform rotation to balnce the tree
//right child is left heavy or left child is right heavy then u need two rotations
//after balancing the tree return the new node
//performing in order traversal will give u sorted data

class Node {

    int key, height;
    Node left, right;

    Node(int key) {
        this.key = key;
        this.height = 0;
    }
}

public class AVLImpl {


    Node root;

    public Node insert(Node node, int key) {

//        step 1 basic BST insertion
        if (node == null) {
            return new Node(key);
        } else if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            return node; //duplicate keys aren't allowed
        }

        //set height of the node
        node.height = 1 + (max(height(node.left), height(node.right)));

        int balance = getBalance(node); //could be -ve or +ve -ve meaning right heavy, +ve meaning left heavy

        /*      z
               y
              x
         */
        if (balance > 1 && key < node.left.key) { //left heavy
            return rightRotate(node); //? or just return whats the difference

        }
        /*      z
               y
                 x
         */
        else if (balance > 1 && key > node.left.key) {
            node = leftRoatate(node);
            return rightRotate(node);
        }
        /*      z
                    y
                         x
         */
        else if (balance < -1 && key > node.right.key) { //right heavy & key is greater than nodes right child
            return leftRoatate(node);
        }
        /*      z
                    y
                  x
         */
        else if (balance < -1 && key < node.right.key) { //right heavy and key is smaller than nodes right child's key
            node = rightRotate(node);
            return leftRoatate(node);
        }


        return node;
    }

    private Node leftRoatate(Node x) {

        Node y = x.right;
        Node t2=y.left;
        //rotation
        y.left=x;
        x.right=t2;

        //update the height
        x.height=1+max(height(x.left),height(x.right));
        y.height=1+max(height(y.left),height(y.right));

        //return the new node
        return y;
    }

    private Node rightRotate(Node y) {

        Node x=y.left;
        Node t2=x.right;
        //rotate
        x.right=y;
        y.left=t2;

        //update the height
        x.height=1+max(height(x.left),height(x.right));
        y.height=1+max(height(y.left),height(y.right));

        return x;


    }

    private int getBalance(Node node) {

        if(node==null){
            return -1;
        }

        return height(node.left)-height(node.right);
    }

    private int max(int left, int right) {

        return left > right ? left : right;
    }

    private int height(Node node) {

        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public static void main(String[] args) {
        AVLImpl tree = new AVLImpl();

        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */
        System.out.println("inOrder traversal" +
                " of constructed tree is : ");
        tree.inOrder(tree.root);
    }

    private void inOrder(Node root) {

        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.key+" ");
        inOrder(root.right);
    }
}
