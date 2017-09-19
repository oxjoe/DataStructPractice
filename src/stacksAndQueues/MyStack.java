package stacksAndQueues;

/**
 * Created by Joseph on 9/13/2017.
 */
// Stack uses LIFO (last-in, first-out) ordering
// Like a stack of dinner plates, most recent is first one to be taken

//  pop(): Removes top item
//  push(item): Adds to top
//  peek(): Return top item of stack
//  isEmpty(): boolean if stack is empty or not

import java.util.EmptyStackException;

// A stack (and queues) can also be implemented using a LinkedList, if items were added and removed from the
// same side

// Copied from CTCI website
public class MyStack<T> {

  private StackNode<T> top;

  public T pop() {
    if (top == null) {
      throw new EmptyStackException();
    }
    T item = top.data;
    top = top.next;
    return item;
  }

  public void push(T item) {
    StackNode<T> t = new StackNode<T>(item);
    t.next = top;
    top = t;
  }

  public T peek() {
    if (top == null) {
      throw new EmptyStackException();
    }
    return top.data;
  }

  public boolean isEmpty() {
    return top == null;
  }

  // StackNode is has a data value of type T and a next StackNode
// Its static b/c unlike say a linked list which adds a new list, we just add to the same node at
// the top of the stack everytime
  private static class StackNode<T> {

    private T data;
    private StackNode<T> next;

    public StackNode(T data) {
      this.data = data;
    }
  }
}

