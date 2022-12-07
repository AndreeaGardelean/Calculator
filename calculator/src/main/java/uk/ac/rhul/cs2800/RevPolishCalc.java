package uk.ac.rhul.cs2800;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Implements Calculator interface and evaluates a Reverse Polish expression to a mathematical
 * value.
 *
 * @author zjac013
 */
public class RevPolishCalc extends CheckElement implements Calculator {
  float result;

  /**
   * Initialises result variable to 0.
   */
  public RevPolishCalc() {
    result = 0;
  }

  @Override
  public float evaluate(String expression) throws InvalidExpressionException {
    NumStack operands = new NumStack(); // store the values here

    String[] expressionValues = expression.split(" ");

    // an expression is invalid if it has an even number of arguments
    if (expressionValues.length % 2 == 0) {
      throw new InvalidExpressionException();
    }

    for (int n = 0; n < expressionValues.length; n++) {
      if (isDigit(expressionValues[n])) {
        operands.push(Float.parseFloat(expressionValues[n]));
      } else if (checkSymbol(expressionValues[n])) {
        try {
          result = operands.pop();
          if (operands.isEmpty()) {
            throw new InvalidExpressionException();
          } else if (expressionValues[n].equals("+")) {
            result = operands.pop() + result;
          } else if (expressionValues[n].equals("-")) {
            result = operands.pop() - result;
          } else if (expressionValues[n].equals("*")) {
            result = operands.pop() * result;
          } else if (expressionValues[n].equals("/")) {
            if (result == 0) {
              throw new ArithmeticException();
            }
            result = operands.pop() / result;

          }
          operands.push(result);
        } catch (BadTypeException e) {
          e.printStackTrace();
        }
      } else if (!isDigit(expressionValues[n]) || !checkSymbol(expressionValues[n])) {
        throw new InvalidExpressionException();
      }
    }

    try {
      result = operands.pop();
    } catch (BadTypeException e) {
      e.printStackTrace();
    }

    // format the resulting expression value to 2 decimal places
    DecimalFormat df = new DecimalFormat("#.##");
    df.setRoundingMode(RoundingMode.FLOOR);

    // df.format(result) will return a string
    // convert from string to float
    result = Float.parseFloat(df.format(result));
    return result;
  }
}
