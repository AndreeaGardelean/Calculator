package uk.ac.rhul.cs2800;

/**
 * Allows the calculation of a String expression.
 *
 * @author zjac013
 */
public interface Calculator {
  /**
   * Evaluate the string expression and output the result or throw an exception if the expression is
   * not a valid mathematical expression.
   *
   * @param expression mathematical string expression to be evaluated and calculated
   * @return return the result of the evaluated mathematical string expression
   * @throws InvalidExpressionException throws an exception if the string is an invalid mathematical
   *         expression.
   */
  public float evaluate(String expression) throws InvalidExpressionException;
}
