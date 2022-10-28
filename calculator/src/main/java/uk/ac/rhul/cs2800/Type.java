package uk.ac.rhul.cs2800;

/**
 * List of type values an entry can represent.
 *
 * @author zjac013
 */
public enum Type {
  NUMBER("float"), SYMBOL("Symbol"), STRING("String"), INVALID("invalid symbol");

  private String description;

  /**
   * Private constructor for an enum.
   *
   * @param description value of the enum
   */
  private Type(String description) {
    this.description = description;
  }

  /**
   * Method returns a string representation of an enum description.
   *
   * @return return a string representation of an enum
   */
  public String toString() {
    return this.description + " data type";
  }
}
