package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TestSymbol {

  Symbol symbol;

  // Test 1
  @Test
  void test() {
    Symbol sy = Symbol.TIMES;
    assertTrue(!(sy.equals(null)));
  }

  // Test 2
  @Test
  void testToString() {
    symbol = Symbol.MINUS;
    assertTrue(symbol.toString().equals("- is subtraction sign"));
  }

  // Test 3
  @Test
  void testUpdateToString() {
    symbol = Symbol.TIMES;
    assertTrue(symbol.toString().equals("* is multiplication sign"));

    symbol = Symbol.DIVIDE;
    assertTrue(symbol.toString().equals("/ is fraction sign"));
  }
}
