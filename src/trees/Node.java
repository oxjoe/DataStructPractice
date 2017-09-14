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

class BinaryTree {

  // Root of Binary Tree
  Node root;

  BinaryTree() {
    root = null;
  }

  // Driver method
  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);

    System.out.println("Preorder traversal of binary tree is ");
    tree.printPreorder(); // 1 2 4 5 3

    System.out.println("\nInorder traversal of binary tree is ");
    tree.printInorder(); // 4 2 5 1 3

    System.out.println("\nPostorder traversal of binary tree is ");
    tree.printPostorder(); // 4 5 2 3 1
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