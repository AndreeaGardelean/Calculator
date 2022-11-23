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

  // Test 8
  // Test if the method throws error when there is a sign other than at the end of the string
  @Test
  void testError2() {
    assertThrows(InvalidExpressionException.class, () -> reversePolish.evaluate("1 + 2"));
  }

  // Test 9
  // Test if there is an error thrown when an invalid sign is in the expression
  @Test
  void testError3() {
    assertThrows(InvalidExpressionException.class, () -> reversePolish.evaluate("1 2 %"));
  }

  // Test 10
  // Test if the method throws error when there are more operators than operands
  @Test
  void testError4() {
    assertThrows(InvalidExpressionException.class, () -> reversePolish.evaluate("1 + /"));
  }

  // Test 11
  // Test if the method throws error when the expression contains '!'
  @Test
  void testError5() {
    assertThrows(InvalidExpressionException.class, () -> reversePolish.evaluate("1 2 !"));
  }

  // Test 15
  @Test
  void testError6() {
    assertThrows(InvalidExpressionException.class, () -> reversePolish.evaluate("1 2 + -"));
  }

  // Test 12
  // Test a longer string expression
  @Test
  void testExpression2() throws InvalidExpressionException {
    assertEquals(reversePolish.evaluate("7 1 - 2 +"), 8);
  }

  // Test 13
  // Test a more complex string expression
  @Test
  void testExpressionComplex() throws InvalidExpressionException {
    assertEquals(reversePolish.evaluate("100 3 / 6 +"), (float) 39.33);
  }

  // Test 14
  // Test a more complex string expression
  @Test
  void testExpressionAllOperators() throws InvalidExpressionException {
    assertEquals(reversePolish.evaluate("10 6 + 18 3 / * 9 -"), (float) 87);
  }
  
  // Test 16
  // Test more situations
  @Test
  void testExpression3() throws InvalidExpressionException {
    assertEquals(reversePolish.evaluate("8 9 * 12 3 / -"), (float) 68);
  }
  
  // Test 17
  @Test
  void testExpression4() throws InvalidExpressionException {
    assertEquals(reversePolish.evaluate("4 5 7 9 2 5 2 + - * / * -"), (float) 4.77);
  }
}
