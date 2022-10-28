package uk.ac.rhul.cs2800;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * The Stack class creates an array stack and implements methods which can be performed on the array
 * stack. The Stack class also represents last-in-first-out (LIFO) stack of objects. The methods
 * push, pop, top, and size are implemented, which can be used to perform certain operations on the
 * array stack.
 *
 * @author zjac013
 */
public class Stack {

  ArrayList<Entry> stack;
  int size;

  /**
   * Create an empty array stack of type Entry.
   */
  public Stack() {
    stack = new ArrayList<Entry>();
  }

  /**
   * Return the number of Entry elements in the array stack.
   *
   * @return the number of elements in the array stack
   */
  public int size() {
    return size;
  }

  /**
   * Add an Entry at the end of the stack and update the stack size variable.
   *
   * @param i the Entry to be appended to the array stack
   */
  public void push(Entry i) {
    stack.add(i);
    size++;
  }

  /**
   * Removes the last element from the array stack and returns it. Update the stack size variable.
   * This method checks if the stack is empty and throws an exception if it is.
   *
   * @return the last element pushed in the array stack
   */
  public Entry pop() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    size--;
    return stack.remove(size);
  }

  /**
   * Returns the first Entry pushed into the array stack. Checks if the stack is empty and throws an
   * exception if it is.
   *
   * @return the top element of the array stack
   */
  public Entry top() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    return stack.get(0);
  }
}
