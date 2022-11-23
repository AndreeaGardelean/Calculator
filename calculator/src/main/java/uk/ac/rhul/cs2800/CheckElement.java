package uk.ac.rhul.cs2800;

/**
 * Class contains only two methods which will be used in RevPolishCalc and StandardCalc class.
 *
 * @author zjac013
 */
public class CheckElement {

  /**
   * Constructor which does nothing, needed to be able to create an object.
   */
  public CheckElement() {

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
}
