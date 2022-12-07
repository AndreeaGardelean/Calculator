package uk.ac.rhul.cs2800;

/**
 * View interface which behaves as an Observable. To be implemented by the graphical user interface
 * and ASCII interface.
 *
 * @author zjac013
 */
public interface ViewInterface {

  /**
   * Get the user input expression.
   *
   * @return return user input
   */
  public String getExpression();

  /**
   * Send the evaluated expression to the GUI.
   *
   * @param ans result of the evaluated expression in a string format
   */
  public void setAnswer(String ans);

  /**
   * Adds an expression observer and notifies the appropriate method to calculate the expression.
   *
   * @param c observer to calculate the expression.
   */
  public void addCalcObserver(Observer c);

  /**
   * Notify observer that a change in expression type has occurred.
   *
   * @param t the observer which notifies about a change in expression type
   */
  public void addTypeObserver(Observer t);

  /**
   * Used to represent an ASCII menu on the command line.
   */
  public void menu();
}