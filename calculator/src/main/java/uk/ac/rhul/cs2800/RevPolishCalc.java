package uk.ac.rhul.cs2800;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Implements Calculator interface and evaluates a Reverse Polish expression to a mathematical
 * value.
 *
 * @author zjac013
 */
public class RevPolishCalc implements Calculator {
  float result;

  /**
   * Initialises result variable to 0.
   */
  public RevPolishCalc() {
    result = 0;
  }

  /**
   * Check if the given string is a valid sign, which was declared in the Symbol enumerated class.
   *
   * @param val string value to be evaluated
   * @return returns the evaluated
   */
  public boolean checkSymbol(String val) {
    char[] value = val.toCharArray();
    return ((value[0] == Symbol.MINUS.getSign()) || (value[0] == Symbol.PLUS.getSign())
        || (value[0] == Symbol.DIVIDE.getSign()) || (value[0] == Symbol.TIMES.getSign()));
  }

  /**
   * Check if the expression contains only digits.
   *
   * @param val string value to evaluate
   * @return return boolean value of the evaluated expression
   */
  public boolean isDigit(String val) {
    for (int i = 0; i < val.length(); i++) {
      if (val.charAt(i) < '0' || val.charAt(i) > '9') {
        return false;
      }
    }
    return true;
  }

  @Override
  public float evaluate(String expression) throws InvalidExpressionException {
    NumStack operands = new NumStack(); // store the values here

    String[] expressionValues = expression.split(" ");

    // a valid mathematical expression always contains an odd number of characters
    // for example: 1 1 +, 2 5 8 - * are valid expressions and the pattern repeats
    // a valid expression will have len/2 + 1 operands
    int operandLength = (int) Math.ceil(expressionValues.length / (double) 2);

    // a valid expression will have len/2 operators
    int operatorLength = expressionValues.length - operandLength;
    String[] operators = new String[operatorLength];

    // an expression is invalid if it has an even number of arguments
    if (expressionValues.length % 2 == 0) {
      throw new InvalidExpressionException();
    }

    // check if there is a mathematical sign in the first part of the expression
    for (int n = operandLength - 1; n > -1; n--) {
      if (!isDigit(expressionValues[n])) {
        throw new InvalidExpressionException();
      } else {
        operands.push(Float.parseFloat(expressionValues[n]));
      }
    }

    // check that the operands are only at the end of the expression
    // if not throw an exception and exit
    for (int i = operandLength; i < expressionValues.length; i++) {
      if (!checkSymbol(expressionValues[i])
          || expressionValues[i] == String.valueOf(Symbol.INVALID.getSign())) {
        throw new InvalidExpressionException();
      } else {
        operators[i - operandLength] = expressionValues[i];
      }
    }

    try {
      result = operands.pop();
      for (int n = 0; n < operatorLength; n++) {
        if (operators[n].equals("+")) {
          result += operands.pop();
        } else if (operators[n].equals("-")) {
          result -= operands.pop();
        } else if (operators[n].equals("*")) {
          result *= operands.pop();
        } else if (operators[n].equals("/")) {
          result = result / operands.pop();
        }
      }
    } catch (BadTypeException e) {
      e.printStackTrace();
    }

    DecimalFormat df = new DecimalFormat("#.##");
    df.setRoundingMode(RoundingMode.FLOOR);

    result = Float.parseFloat(df.format(result));
    System.out.println(result);
    return result;
  }
}
