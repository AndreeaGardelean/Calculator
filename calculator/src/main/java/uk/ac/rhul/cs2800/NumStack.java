package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * NumStack is a facade which creates a Stack of float Entry values.
 *
 * @author zjac013
 */
public class NumStack {

  private Stack numStack;

  /**
   * Constructor to initialise the NumStack Stack.
   */
  public NumStack() {
    numStack = new Stack();
  }

  /**
   * Check is the stack is empty and return a boolean value describing its state.
   *
   * @return return the result of the boolean expression
   */
  public Boolean isEmpty() {
    return (numStack.size() == 0);
  }

  /**
   * Push a new float Entry onto the stack and update the stack size.
   *
   * @param f float value for a new stack entry
   */
  public void push(float f) {
    numStack.push(new Entry(f));
  }

  /**
   * Remove and return the last item pushed onto the stack.
   *
   * @return return the last float entry pushed onto the stack
   * @throws BadTypeException throw exception if the getValue() method returns a different data type
   */
  public float pop() throws BadTypeException {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return numStack.pop().getValue();
  }
}


