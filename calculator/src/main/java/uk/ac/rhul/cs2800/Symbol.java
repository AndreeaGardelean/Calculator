package uk.ac.rhul.cs2800;

/**
 * List of non-number possible symbols in a mathematical expression.
 *
 * @author zjac013
 */

public enum Symbol {
  LEFT_BRACKET('(', "left bracket"), RIGHT_BRACKET(')', "right bracket"), TIMES('*',
      "multiplication"), DIVIDE('/', "fraction"), PLUS('+',
          "addition"), MINUS('-', "subtraction"), FACTORIAL('!', "factorial");

  private char sign;
  private String description;

  /**
   * Single constructor for enum value.
   *
   * @param sign the sign character an expression can contain
   * @param desc the description of the expression character
   */
  private Symbol(char sign, String description) {
    this.sign = sign;
    this.description = description;
  }

  /**
   * Return the sign value of the enumerated type.
   *
   * @return return the character value of the enumerated type
   */
  public char getSign() {
    return sign;
  }

  /**
   * Returns a string representation of the enum attribute fields.
   *
   * @return a String representation of the enum attributes
   */
  @Override
  public String toString() {
    return this.sign + " is " + this.description + " sign";
  }
}
