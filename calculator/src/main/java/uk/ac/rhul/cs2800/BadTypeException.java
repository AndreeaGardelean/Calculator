package uk.ac.rhul.cs2800;

/**
 * This class creates a new exception. This class is a subclass of the Exception class.
 *
 * @author zjac013
 *
 */

// @SuppressWarnings("serial") will ignore the warning given by the BadTypeException class regarding
// the serial version ID
@SuppressWarnings("serial")
public class BadTypeException extends Exception {

  /**
   * Constructor for the exception. The constructor prints a message when the exception is thrown.
   */
  public BadTypeException() {
    System.err.println("The Entry data type different from that of getter data type: ");
  }

}
