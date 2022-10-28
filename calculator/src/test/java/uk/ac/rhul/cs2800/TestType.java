package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TestType {
  Type type;

  // Test 1
  @Test
  void testCreate() {
    Type type = Type.NUMBER;
    assertTrue(!(type.equals(null)));
  }

  // Test 2
  @Test
  void testToString() {
    type = Type.SYMBOL;
    assertTrue(type.toString().equals("Symbol data type"));
  }

  // Test 3
  @Test
  void testToString2() {
    type = Type.STRING;
    assertTrue(type.toString().equals("String data type"));
  }

}
