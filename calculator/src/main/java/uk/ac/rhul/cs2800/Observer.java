package uk.ac.rhul.cs2800;

/**
 * Java Functional Interface Observer which is used by the GUI to notify the observer that a change
 * has occurred.
 *
 * @author zjac013
 */
@FunctionalInterface
public interface Observer {
  /**
   * Notifies the observer when a change has occurred.
   */
  public void notifyObservers();
}
