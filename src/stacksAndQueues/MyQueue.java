package stacksAndQueues;

/**
 * Created by Joseph on 9/13/2017.
 */
// Queue is FIFO (First-in first-out) like a ticket line

// add(item): Add to the end of list
// remove(): Remove first item in the list
// peek(): Return first item
// isEmpty(): Checks if queue is empty

// Queue can also be implemented with a linked list.
// They are the essentially the same thing if:
//   Items are added and removed from opposite sides

// Queues are used in BFS b/c we can process nodes in the order which they are viewed. Each time
// we process a node, we add its adjacent nodes to the back of the queue

import java.util.NoSuchElementException;

// Copied from CTCI website
public class MyQueue<T> {

  private QueueNode<T> first;
  private QueueNode<T> last;

  public void add(T item) {
    QueueNode<T> t = new QueueNode<T>(item);
    if (last != null) {
      last.next = t;
    }
    last = t;
    if (first == null) {
      first = last;
    }
  }

  public T remove() {
    if (first == null) {
      throw new NoSuchElementException();
    }
    T data = first.data;
    first = first.next;
    if (first == null) {
      last = null;
    }
    return data;
  }

  public T peek() {
    if (first == null) {
      throw new NoSuchElementException();
    }
    return first.data;
  }

  public boolean isEmpty() {
    return first == null;
  }

  private static class QueueNode<T> {

    private T data;
    private QueueNode<T> next;

    public QueueNode(T data) {
      this.data = data;
    }
  }
}

