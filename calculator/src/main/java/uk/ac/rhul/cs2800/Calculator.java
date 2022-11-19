package uk.ac.rhul.cs2800;

/**
 * Allows the calculation of a String expression.
 *
 * @author zjac013
 */
public interface Calculator {
  /**
   * Evaluated the string expression and outputs the result or throws an exception if the expression
   * is not a valid mathematical expression.
   *
   * @param expression string expression to be evaluated and calculated
   * @return return the result of the evaluated string expression
   * @throws InvalidExpressionException throws a custom expression if the string is an invalid
   *         mathematical expression.
   */
  public float evaluate(String expression) throws InvalidExpressionException;
}
