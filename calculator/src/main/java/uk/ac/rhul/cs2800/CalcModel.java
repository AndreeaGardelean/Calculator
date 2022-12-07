package uk.ac.rhul.cs2800;

/**
 * Evaluates the user mathematical string expression, sets the state of the calculator and evaluates
 * the expression based on calculator state.
 *
 * @author zjac013
 */
public class CalcModel {
  private static RevPolishCalc revPolishCalc;
  private static StandardCalc standard;
  private Calculator currentEvaluator;
  private float result = 0;

  /**
   * Constructor to initialise the needed objects.
   */
  public CalcModel() {
    revPolishCalc = new RevPolishCalc();
    standard = new StandardCalc();
    currentEvaluator = revPolishCalc;
  }

  /**
   * Set the current state of the calculator, the state is set by the Observer.
   *
   * @param infix boolean value representing the sate of the calculator
   */
  public void setType(boolean infix) {
    if (infix) {
      currentEvaluator = standard;
    } else {
      currentEvaluator = revPolishCalc;
    }
  }

  /**
   * Evaluate the mathematical expression by calling the method of the current calculator state. The
   * appropriate calculator is called based on the currentEvaluator value.
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
