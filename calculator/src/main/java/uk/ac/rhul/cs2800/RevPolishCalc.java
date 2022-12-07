package uk.ac.rhul.cs2800;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Implements Calculator interface and evaluates a Reverse Polish notation mathematical expression
 * to a float value.
 *
 * @author zjac013
 */
public class RevPolishCalc implements Calculator {
  private NumStack operands;
  private CheckElement checkElem;
  private float result;

  /**
   * Instantiates the needed objects.
   */
  public RevPolishCalc() {
    operands = new NumStack();
    checkElem = new CheckElement();
    result = 0;
  }

  /**
   * Evaluate the value of the operand using the string representation of the operator.
   *
   * @param operand value to be evaluated
   * @param operator string value containing one mathematical operator
   * @return return a float value which is the evaluation of operand and result using the operator
   */
  public float charToOperator(float operand, String operator) {
    float val = 0;
    if (operator.equals("+")) {
      val = (operand + result);
    } else if (operator.equals("-")) {
      val = (operand - result);
    } else if (operator.equals("*")) {
      val = (operand * result);
    } else if (operator.equals("/")) {
      if (result == 0) {
        throw new ArithmeticException();
      }
      val = (operand / result);
    }
    return val;
  }

  /**
   * Round a floating point value to 2 decimal places.
   *
   * @param value float value to be rounder to 2 decimal places
   * @return returns the rounded floating-point value to 2 decimal places
   */
  public float format(float value) {
    // format the resulting expression value to 2 decimal places
    DecimalFormat df = new DecimalFormat("#.##");
    df.setRoundingMode(RoundingMode.FLOOR);

    // convert from string to float because the above line return a string value
    return Float.parseFloat(df.format(result));
  }


  @Override
  public float evaluate(String expression) throws InvalidExpressionException {
    String[] expressionValues = expression.split("\\s+");

    // an expression is invalid if it has an even number values
    if (expressionValues.length % 2 == 0) {
      throw new InvalidExpressionException();
    }

    for (int n = 0; n < expressionValues.length; n++) {

      if (checkElem.isDigit(expressionValues[n])) {
        operands.push(Float.parseFloat(expressionValues[n]));

      } else if (checkElem.checkSymbol(expressionValues[n])) {
        try {
          result = operands.pop();
          if (operands.isEmpty()) {
            throw new InvalidExpressionException();
          } else {
            result = charToOperator(operands.pop(), expressionValues[n]);
          }
          operands.push(result);
        } catch (BadTypeException e) {
          e.printStackTrace();
        }
      } else if (!checkElem.isDigit(expressionValues[n])
          || !checkElem.checkSymbol(expressionValues[n])) {
        throw new InvalidExpressionException();
      }
    }

    // get the result of the evaluated expression from the stack
    try {
      result = operands.pop();
    } catch (BadTypeException e) {
      e.printStackTrace();
    }
    return format(result);
  }
}
