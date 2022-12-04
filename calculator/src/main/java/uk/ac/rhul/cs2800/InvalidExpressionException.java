package uk.ac.rhul.cs2800;

/**
 * Exception thrown in the case when an invalid mathematical expression has been entered.
 *
 * @author zjac013
 */
public class InvalidExpressionException extends Exception {

  /**
   * Generated value identifier used to serialise/deserialise the exception.
   */
  private static final long serialVersionUID = -9001860817336438137L;

  /**
   * Exception constructor. Prints exception message.
   */
  public InvalidExpressionException() {
    System.err.println("Invalid mathematical expression");
  }
}
