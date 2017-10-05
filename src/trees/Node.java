package trees;

/**
 * Created by Joseph on 9/12/2017.
 */

// todo pg 103 - 107

// min-heap: minimum on top
// max-heap: maximum on top
// min-heap insert is O(log n)
// min-heap extract_min is O(log n)

// Depth-First Search (DFS): Go deep from selected node (root or other)
//   - Mostly used to visit every node in the graph
//  In-order, Pre-order, and Post-order traversals are Depth-First traversals
// Breadth-First Search (BFS): Go wide from selected node (root or other)
//   - Mostly used to find shortest or any pth between two nodes

// Binary Tree has up to two leaves
// Binary Search Tree has comparisons
// all left descendants <= number of all right descendants

// Complete Binary Tree is filled left to right
// Full Binary Tree can only have 0 or 2 children
// Perfect Binary Tree is both complete and full
// Also is what you expect it to look like; has (2^k) - 1 # of nodes where k is # of levels

// Copied from geeksforgeeks.com
/* Class containing left and right child of current
   node and key value*/
// Node has:
//  - Key: some form of data
//  - Node Left: On the left of the current node, there is another node that is either null or
// has data
//  - Node Right: On the right of the current node, there is another node that is either null or
// has data
class Node {

  int key;
  Node left, right;

  Node(int item) {
    key = item;
    left = right = null;
  }
}

// Whats the difference between Binary Tree and Binary Search Tree?
// BST has the less than on left and greater then on right requirements
class BinaryTree {

  // Root of Binary Tree
  Node root;

  BinaryTree() {
    root = null;
  }

  // Driver method
  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();

    tree.root = insert(tree.root, 50);
//    insert(tree.root, 30);
//    insert(tree.root, 20);
    insert(tree.root, 40);
    insert(tree.root, 70);
    insert(tree.root, 60);
    insert(tree.root, 80);

    tree.printInorder();
    System.out.println();
    System.out.println("After delete");
    delete(tree.root, 50);
    tree.printInorder();

//    System.err.println("CHECK IF MATCH");
//    System.out.println("In Order (20 30 40 50 60 70 80): ");
//    tree.printInorder();
//    System.out.println("\n");
//    System.out.println("Pre Order (50 30 20 40 70 60 80): ");
//    tree.printPreorder();
//    System.out.println("\n");
//    System.out.println("Post Order (20 40 30 60 80 70 50 ): ");
//    tree.printPostorder();
  }

  // takeaway: first 3 cases are basically insert
//  takeaway: delete has some of insert and insert has some of delete
  static Node delete(Node root, int key) {
        /* Base Case: If the tree is empty */
    if (root == null) {
      return root;
    }
        /* Otherwise, recur down the tree */
    if (key < root.key) {
      root.left = delete(root.left, key);
    } else if (key > root.key) {
      root.right = delete(root.right, key);
    }

    // if key is same as root's key, then This is the node
    // to be deleted
    else {
      // node with only one child or no child
//      if node.left has nothing then return the right b/c its either null or has something and
// vice versa
      if (root.left == null) { // this one deletes left
        return root.right;
      } else if (root.right == null) {
        return root.left;
      }
// takeaway This part is the node with 2 subtrees

      // node with two children: Get the inorder successor (smallest
      // in the right subtree)
      // takeaway set node value as right subtree
      // takeaway this gets the inorder ancestor and sets it as the current node
      root.key = minValue(root.right);
      // Deletes the inorder successor
      root.right = delete(root.right, root.key);
    }
    System.out.println(root.key);
    return root;
  }

  static int minValue(Node root) {
    while (root.left != null) {
      root = root.left;
    }
    return root.key;
  }

  static Node insert(Node n, int k) {
    if (n == null) {
      Node make = new Node(k);
      return make;
    } else if (k > n.key) {
      n.right = insert(n.right, k);
    } else if (k < n.key) {
      n.left = insert(n.left, k);
    }
    return n;
  }

  static Node search(Node n, int k) {
    if (n == null || n.key == k) {
      return n;
    }
    if (k > n.key) {
      return search(n.right, k);
    } else {
      return search(n.left, k);
    }
  }

  // Visits left-right-root, b/c post is after
  void printPostorder(Node node) {
    if (node != null) {
      printPostorder(node.left);
      printPostorder(node.right);
      System.out.print(node.key + " ");
    }
  }

  // Visits in the normal order of what you expect (left-root-right)
  void printInorder(Node node) {
    if (node != null) {
      printInorder(node.left);
      System.out.print(node.key + " ");
      printInorder(node.right);
    }
  }

  // Visits root-left-right, b/c pre is before
  void printPreorder(Node node) {
    if (node != null) {
      System.out.print(node.key + " ");
      printPreorder(node.left);
      printPreorder(node.right);
    }
  }

  // Wrappers over above recursive functions
  void printPostorder() {
    printPostorder(root);
  }

  void printInorder() {
    printInorder(root);
  }

  void printPreorder() {
    printPreorder(root);
  }
}