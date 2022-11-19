package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRevPolishCalc {
  RevPolishCalc reversePolish;

  @BeforeEach
  void setup() {
    reversePolish = new RevPolishCalc();
  }

  // Test 1
  // Try the constructor
  @Test
  void testSetUp() {
    reversePolish = new RevPolishCalc();
  }

  // Test 2
  // Test a basic expression
  @Test
  void testSimpleExpression() throws InvalidExpressionException {
    assertEquals(reversePolish.evaluate("1 1 +"), 2,
        "1 1 + in Reverse Polish notation should return 2.");
  }

  // Test 3
  // Test a valid symbol
  @Test
  void testCheckSymbol() {
    assertTrue(reversePolish.checkSymbol("+"),
        "+ is a valid symbol. Can be used to evaluate the expression");
  }

  // Test 4
  @Test
  void testCheckSymbolInvalid() {
    assertFalse(reversePolish.checkSymbol("&"),
        "& is not a valid symbol to calculate the expression");
  }

  // Test 5
  // Test if a string contains only digits
  @Test
  void testIsDigit() {
    assertTrue(reversePolish.isDigit("10"));
  }

  // Test 6
  // Test if the method returns false when the string contains other characters
  @Test
  void testIsNotDigit() {
    assertFalse(reversePolish.isDigit("1$8"));
  }
  
  // Test 7
  // Test if exception is thrown when it contains an even number of values
  @Test
  void testError1() {
    assertThrows(InvalidExpressionException.class, () -> reversePolish.evaluate("1 2 3 -"));
  }

}
