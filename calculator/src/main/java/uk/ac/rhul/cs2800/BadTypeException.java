package uk.ac.rhul.cs2800;

/**
 * This class creates a new exception. This class is a subclass of the Exception class.
 *
 * @author zjac013
 *
 */

public class BadTypeException extends Exception {

  /**
   * Generated value identifier used to serialise/deserialise the exception.
   */
  private static final long serialVersionUID = 902259016746188985L;

  /**
   * Constructor for the exception. The constructor prints a message when the exception is thrown.
   */
  public BadTypeException() {
    System.err.println("The Entry data type different from that of getter data type: ");
  }

}
