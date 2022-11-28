package uk.ac.rhul.cs2800;

/**
 * View interface which behaves as an Observable.
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
   * @param str evaluated expression in a string format
   */
  public void setAnswer(String str);

  /**
   * Adds an expression observer and notifies the appropriate method to calculate the expression.
   *
   * @param f observer to calculate the expression.
   */
  public void addCalcObserver(Observer f);

  /**
   * Notify observer that a change in expression type has occurred.
   *
   * @param l the observer which notifies about a change in expression type
   */
  public void addTypeObserver(Observer l);
}
