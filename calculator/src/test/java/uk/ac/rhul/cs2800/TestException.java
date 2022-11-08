package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class TextException {

  // Test 1
  // Test if the exception can be thrown
  @Test
  void test() throws BadTypeException {
    Entry en = new Entry(4.34f);
    assertThrows(BadTypeException.class, () -> en.getStr(), "The entry is not of type String, cannot call String getter on a float type");
  }
}
