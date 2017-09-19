package linkedList;

/* Linked list Node.  This inner class is made static so that
   main() can access it */
class Node {

  int key;
  Node next;

  Node(int d) {
    key = d;
    next = null;
  }
}

/**
 * Created by Joseph on 9/17/2017.
 */
// A simple Java program to introduce a linked list
class LinkedList {

  Node head;  // head of list

  static LinkedList createList(int sizeOfLinkedList) {
    // Create
    // I dont want to mess with the head b/c its gonna stay the same.
    // Which is why we wrap the node class inside LinkedList so head will the same otherwise we
    // won't know which node is the head b/c we could keep manipulating it (instead of using temp)
    // Takeaway: Node temp = head, Node makeNode = new Node(i)
    LinkedList llist = new LinkedList();
    llist.head = new Node(0);

    Node temp = llist.head;
    for (int i = 1; i <= sizeOfLinkedList; i++) {
      Node makeNode = new Node(i);
      temp.next = makeNode;
      temp = makeNode;
    }
    return llist;
  }


  public static void main(String[] args) {
    int sizeOfLinkedList = 6;
    LinkedList llist = createList(sizeOfLinkedList);

    Node temp = llist.head;
    Node insertMid = new Node(111);

    while (temp != null) {
      if (temp.key == 7) {
        Node toBePointed = temp.next;
        temp.next = insertMid;
        insertMid.next = toBePointed;
        break;
      }
      temp = temp.next;
    }
    llist.printList();
    System.out.println();
    // Delete Head
//    llist.head = llist.head.next;

//    Delete Middle - remove 2
    int toBeDelete = 2;
    if (llist.head.key == toBeDelete) {
      llist.head = llist.head.next;
    } else {
      temp = llist.head.next;
      while (temp.next != null) {
        if (temp.next.key == toBeDelete) {
          temp.next = temp.next.next;
          break;
        } else {
          temp = temp.next;
        }
      }
    }

    llist.printList();
    // Search
    // I dont want to mess with the head b/c its gonna stay the same
//    Takeaway: Node temp = head, temp = temp.next
    // Takeaway Basically the same as printList so search == access
//    Node temp = llist.head;
//    int findMe = 7;
//    temp = llist.head;
//    while (temp != null) {
//      if (temp.key == findMe) {
//        System.out.println("found the element");
//      }
//      temp = temp.next;
//    }
//    llist.printList();

    // Insert LAST
//    // Takeaway: Having Node temp = head in beg, and elsewhere temp = temp.next
//    Node insertMe = new Node(99999);
//    Node temp = llist.head;
//    while (temp != null) {
//      if (temp.next == null) {
//        temp.next = insertMe;
//        break;
//      }
//      temp = temp.next;
//    }
//    System.out.println();
//    llist.printList();

//    System.out.println("INSERT FIRST");
//    // Insert FIRST
//    Node newHead = new Node(-1);
//    newHead.next = llist.head;
//    llist.head = newHead;
//    llist.printList();
  }

  public void printList() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.key + " ");
      temp = temp.next;
    }
  }
}