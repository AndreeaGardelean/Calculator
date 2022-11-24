package uk.ac.rhul.cs2800;

/**
 * Shows the expression result of each of the calculator values.
 *
 * @author zjac013
 */
public class CalcModel {
  private RevPolishCalc revPolishCalc;
  private StandardCalc standard;
  private float result;

  /**
   * Constructor to initialise the answer.
   */
  public CalcModel() {
    revPolishCalc = new RevPolishCalc();
    standard = new StandardCalc();
    result = 0;
  }

  /**
   * The methods accepts an expression to be evaluated and a boolean value which indicated wether is
   * in infix notation or not. Based on the boolean value the appropriate classes will be called.
   *
   * @param expression user input expression to be evaluated
   * @param infix boolean value for the expression if is in infix notation or not
   * @return returns a floating point value of the evaluated expression
   * @throws InvalidExpressionException the classes called in this method will throw an exception if
   *         the expression contains invalid mathematical characters
   */
  public float evaluate(String expression, boolean infix) throws InvalidExpressionException {
    if (infix) {
      result = standard.evaluate(expression);
    } else if (!infix) {
      result = revPolishCalc.evaluate(expression);
    }
    return result;
  }
}
