package uk.ac.rhul.cs2800;

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
    return ((value[0] == Symbol.LEFT_BRACKET.getSign())
        || (value[0] == Symbol.RIGHT_BRACKET.getSign()) || (value[0] == Symbol.MINUS.getSign())
        || (value[0] == Symbol.PLUS.getSign()) || (value[0] == Symbol.DIVIDE.getSign())
        || (value[0] == Symbol.TIMES.getSign()) || (value[0] == Symbol.INVALID.getSign()));
  }
  
  
  @Override
  public float evaluate(String expression) throws InvalidExpressionException {
    return 2;
  }
  
  
}
