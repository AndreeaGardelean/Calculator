package uk.ac.rhul.cs2800;

/**
 * Evaluates an infix string expression. Converts the infix expression to reverse polish notation
 * and evaluates the expression to invalid or a floating point value.
 *
 * @author zjac013
 */
public class StandardCalc extends CheckElement implements Calculator {

  OpStack operators;
  StrStack operands;
  RevPolishCalc rpCalc;

  Symbol stringToSymbol(String val) {
    Symbol symbol = Symbol.INVALID;
    if (val.equals("/")) {
      symbol = Symbol.DIVIDE;
    } else if (val.equals("*")) {
      symbol = Symbol.TIMES;
    } else if (val.equals("-")) {
      symbol = Symbol.MINUS;
    } else if (val.equals("+")) {
      symbol = Symbol.PLUS;
    }
    return symbol;
  }

  /**
   * Construct which initialises the needed stacks.
   */
  public StandardCalc() {
    operators = new OpStack();
    operands = new StrStack();
    rpCalc = new RevPolishCalc();
  }

  @Override
  public float evaluate(String expression) throws InvalidExpressionException {
    String[] values = expression.split(" ");
    String expressionRpn = new String("");

    final float result;

    for (int n = 0; n < values.length; n++) {
      if (isDigit(values[n])) {
        operands.push(values[n]);

      } else if (checkSymbol(values[n]) || values[n].equals("(")) {
        operators.push(stringToSymbol(values[n]));
      }
    }

    for (int i = 0; i <= (values.length / 2); i++) {
      try {
        expressionRpn = operands.pop() + " " + expressionRpn;
        if (i > 0) {
          expressionRpn += operators.pop().getSign() + " ";
        }
      } catch (BadTypeException e) {
        e.printStackTrace();
      }
    }

    System.out.println("expression= " + expressionRpn);
    result = rpCalc.evaluate(expressionRpn);

    return result;
  }
}

