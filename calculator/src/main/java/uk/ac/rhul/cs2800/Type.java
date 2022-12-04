package uk.ac.rhul.cs2800;

/**
 * List of type values an expression can contain.
 *
 * @author zjac013
 */
public enum Type {
  NUMBER("float"), SYMBOL("Symbol"), STRING("String"), INVALID("invalid symbol");

  private String description;

  /**
   * Private constructor for an enumeration class.
   *
   * @param description value of the enumeration object
   */
  private Type(String description) {
    this.description = description;
  }

  /**
   * Method returns a string representation of an enumeration object description.
   *
   * @return return a string representation of an enumeration object
   */
  public String toString() {
    return this.description + " data type";
  }
}
