package uk.ac.rhul.cs2800;

/**
 * Converts an infix mathematical expression to reverse polish notation and calls the class
 * RevPolishCalc to evaluate the expression and return the result of the expression.
 *
 * @author zjac013
 */
public class StandardCalc extends CheckElement implements Calculator {

  OpStack values;
  RevPolishCalc rpCalc;

  /**
   * Constructor which initialises the operand stack and the reverse polish calculator.
   */
  StandardCalc() {
    values = new OpStack();
    rpCalc = new RevPolishCalc();
  }

  @Override
  public float evaluate(String expression) throws InvalidExpressionException {
    String[] vals = expression.split(" ");
    String rpExpr = "";

    if (isDigit(vals[0]) && isDigit(vals[1])) {
      throw new InvalidExpressionException();
    }

    for (int i = 0; i < vals.length; i++) {
      if (!(checkSymbol(vals[i]) || isDigit(vals[i]) || vals[i].equals("(")
          || vals[i].equals(")"))) {
        System.out.println("Not a symbol or a digit");
        throw new InvalidExpressionException();
      }

      if (checkSymbol(vals[i]) || vals[i].equals("(")) {
        values.push(strToSymbol(vals[i]));
      }

      if (vals[i].equals(")")) {
        try {
          while (!values.isEmpty()) {
            Symbol s = values.pop();
            if (s == Symbol.RIGHT_BRACKET) {
              break;
            }
            rpExpr += s.getSign() + " ";
          }
          // values.pop();
        } catch (BadTypeException e) {
          e.printStackTrace();
        }
      }
      if (isDigit(vals[i])) {
        rpExpr += vals[i] + " ";
      }
    }

    while (!values.isEmpty()) {
      try {
        rpExpr += values.pop().getSign() + " ";
      } catch (BadTypeException e) {
        e.printStackTrace();
      }
    }
    System.out.println(rpExpr);
    return rpCalc.evaluate(rpExpr);

  }



  /**
   * Method which checks if a given value is one of the valid mathematical operands defined in the
   * enumerated class.
   *
   * @param val mathematical operand to be evaluated
   * @return return the Symbol value of the input operand
   */
  public Symbol strToSymbol(String val) {
    Symbol symbol = Symbol.INVALID;

    if (val.length() > 1) {
      return symbol;
    }
    if (val.equals("*")) {
      symbol = Symbol.TIMES;
    }
    if (val.equals("/")) {
      symbol = Symbol.DIVIDE;
    }
    if (val.equals("-")) {
      symbol = Symbol.MINUS;
    }
    if (val.equals("+")) {
      symbol = Symbol.PLUS;
    }
    if (val.equals("(")) {
      symbol = Symbol.RIGHT_BRACKET;
    }
    if (val.equals(")")) {
      symbol = Symbol.LEFT_BRACKET;
    }
    return symbol;
  }
}
