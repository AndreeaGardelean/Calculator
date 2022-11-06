package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * Create a stack for string entries.
 *
 * @author zjac013
 *
 */
public class StrStack {
  private Stack stringStack;

  /**
   * Constructor to initialise the stack.
   */
  public StrStack() {
    stringStack = new Stack();
  }

  /**
   * Return a boolean which evaluates if the size is 0 or not.
   *
   * @return returns a boolean value which evaluates if the stack size equals to 0 or no
   */
  public boolean isEmpty() {
    return (stringStack.size() == 0);
  }

  /**
   * Push a new string entry onto the stack.
   *
   * @param string string value to be added to the stack
   */
  public void push(String string) {
    stringStack.push(new Entry(string));
  }

  /**
   * Pop and return the last item pushed onto the stack.
   *
   * @return return the last item pushed onto the stack.
   * @throws BadTypeException throw an exception if the return type of getStr() is different of that
   *         of the stack entry.
   */
  public String pop() throws BadTypeException {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return stringStack.pop().getStr();
  }
}
