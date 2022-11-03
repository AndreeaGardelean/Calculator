package uk.ac.rhul.cs2800;

/**
 * NumStack created a stack for numeric values.
 *
 * @author zjac013
 */
public class NumStack {

  private Stack numStack;

  /**
   * Constructor to initialise the numStack variable.
   */
  public NumStack() {
    numStack = new Stack();
  }

  /**
   * Compute and return the Stack size.
   *
   * @return return the Stack size
   */
  public int size() {
    return numStack.size();
  }

  /** Push a new float Entry into the stack and update the stack size.
   *
   * @param f float value for a new stack entry
   */
  public void push(float f) {
    numStack.push(new Entry(f));    
  }

  /**
   * Remove and return the last item pushed onto the stack.
   *
   * @return return the last item pushed into the stack
   */
  public float pop() throws BadTypeException {
    return numStack.pop().getValue();
  }

  /**
   * Check is the stack is empty and return a boolean value.
   *
   * @return return the result of the boolean expression
   */
  public Boolean isEmpty() {
    return (numStack.size() == 0);
  }
}













