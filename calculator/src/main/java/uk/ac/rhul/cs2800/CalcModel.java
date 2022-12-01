package uk.ac.rhul.cs2800;

/**
 * Shows the expression result of each of the calculator values.
 *
 * @author zjac013
 */
public class CalcModel {
  private static RevPolishCalc revPolishCalc;
  private static StandardCalc standard;
  Calculator currentEvaluator = revPolishCalc;
  private float result = 0;

  /**
   * Constructor to initialise the answer.
   */
  public CalcModel() {
    revPolishCalc = new RevPolishCalc();
    standard = new StandardCalc();
  }

  /**
   * Method evaluate the current state of the calculator. 
   *
   * @param infix boolean value which is the evaluation of the expression if the value is in infix
   *        notation.
   */
  public void setType(boolean infix) {
    if (infix) {
      currentEvaluator = standard;
    } else {
      currentEvaluator = revPolishCalc;
    }
  }

  /**
   * The methods accepts an expression to be evaluated and a boolean value which indicated wether is
   * in infix notation or not. Based on the boolean value the appropriate classes will be called.
   *
   * @param expression user input expression to be evaluated
   * @return returns a floating point value of the evaluated expression
   * @throws InvalidExpressionException the classes called in this method will throw an exception if
   *         the expression contains invalid mathematical characters
   */
  public float evaluate(String expression) throws InvalidExpressionException {
    result = currentEvaluator.evaluate(expression);
    return result;
  }
}
