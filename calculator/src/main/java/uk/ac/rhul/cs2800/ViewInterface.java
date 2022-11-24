package uk.ac.rhul.cs2800;

import java.util.function.Consumer;

/**
 * Interface for a view.
 *
 * @author zjac013
 */
public interface ViewInterface {
  
  /**
   * Get the expression the user has entered.
   *
   * @return return the user expression.
   */
  public String getExpression();
  
  /**
   * Send the evaluated expression to the GUI.
   *
   * @param str evaluated expression string output
   */
  public void setAnswer(String str);
  
  /**
   * Add an observer.
   *
   * @param f add a runnable
   */
  public void addCalcObserver(Runnable f);
  
  /**
   * Add the type of the observer.
   *
   * @param l add the consumer type
   */
  public void addTypeObserver(Consumer<String> l);
  
}
