package uk.ac.rhul.cs2800;

/**
 * Converts an infix mathematical expression to reverse polish notation and calls the class
 * RevPolishCalc to evaluate the expression and return the result of the expression.
 *
 * @author zjac013
 */
public class StandardCalc implements Calculator {

  private OpStack values;
  private RevPolishCalc rpCalc;
  private CheckElement checkElem;

  /**
   * Constructor to instantiates the needed objects.
   */
  StandardCalc() {
    values = new OpStack();
    rpCalc = new RevPolishCalc();
    checkElem = new CheckElement();
  }

  @Override
  public float evaluate(String expression) throws InvalidExpressionException {
    String[] vals = expression.split(" ");
    String rpExpr = "";

    for (int i = 0; i < vals.length; i++) {
      if (!(checkElem.checkSymbol(vals[i]) || checkElem.isDigit(vals[i]) || vals[i].equals("(")
          || vals[i].equals(")"))) {
        throw new InvalidExpressionException();
      }
      if (i > 0 && checkElem.isDigit(vals[i - 1]) && checkElem.isDigit(vals[i])) {
        throw new InvalidExpressionException();
      }

      if (checkElem.checkSymbol(vals[i]) || vals[i].equals("(")) {
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
        } catch (BadTypeException e) {
          e.printStackTrace();
        }
      }
      if (checkElem.isDigit(vals[i])) {
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
    return rpCalc.evaluate(rpExpr);
  }

  /**
   * Method checks if a given value is one of the valid mathematical operands defined in the
   * enumerated class.
   *
   * @param val mathematical operand to be evaluated
   * @return return the Symbol value equivalent to the input value
   */
  public Symbol strToSymbol(String val) {
    Symbol symbol = Symbol.INVALID;

    if (val.length() > 1) {
      return symbol;
    }
    if (val.equals("*")) {
      return Symbol.TIMES;
    }
    if (val.equals("/")) {
      return Symbol.DIVIDE;
    }
    if (val.equals("-")) {
      return Symbol.MINUS;
    }
    if (val.equals("+")) {
      return Symbol.PLUS;
    }
    if (val.equals("(")) {
      return Symbol.RIGHT_BRACKET;
    }
    if (val.equals(")")) {
      return Symbol.LEFT_BRACKET;
    }
    return symbol;
  }
}
