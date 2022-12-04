package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
  // Test if exception is thrown when it contains an even number of values
  @Test
  void testError1() {
    assertThrows(InvalidExpressionException.class, () -> reversePolish.evaluate("1 2 3 -"));
  }

  // Test 4
  // Test if the method throws error when the expression is infix notation
  @Test
  void testError2() {
    assertThrows(InvalidExpressionException.class, () -> reversePolish.evaluate("1 + 2"));
  }

  // Test 5
  // Test if there is an error thrown when an invalid sign is in the expression
  @Test
  void testError3() {
    assertThrows(InvalidExpressionException.class, () -> reversePolish.evaluate("1 2 %"));
  }

  // Test 6
  // Test if the method throws error when there are more operators than operands
  @Test
  void testError4() {
    assertThrows(InvalidExpressionException.class, () -> reversePolish.evaluate("1 + /"));
  }

  // Test 7
  // Test if the method throws error when the expression contains '!'
  @Test
  void testError5() {
    assertThrows(InvalidExpressionException.class, () -> reversePolish.evaluate("1 2 !"));
  }

  // Test 8
  @Test
  void testError6() {
    assertThrows(InvalidExpressionException.class, () -> reversePolish.evaluate("1 2 + -"));
  }

  // Test 9
  // Test a longer string expression
  @Test
  void testExpression2() throws InvalidExpressionException {
    assertEquals(reversePolish.evaluate("7 1 - 2 +"), 8);
  }

  // Test 10
  // Test a more complex string expression
  @Test
  void testExpressionComplex() throws InvalidExpressionException {
    assertEquals(reversePolish.evaluate("100 3 / 6 +"), (float) 39.33);
  }

  // Test 11
  // Test a more complex string expression
  @Test
  void testExpressionAllOperators() throws InvalidExpressionException {
    assertEquals(reversePolish.evaluate("10 6 + 18 3 / * 9 -"), (float) 87);
  }

  // Test 12
  // Test more situations
  @Test
  void testExpression3() throws InvalidExpressionException {
    assertEquals(reversePolish.evaluate("8 9 * 12 3 / -"), (float) 68);
  }

  // Test 13
  @Test
  void testExpression4() throws InvalidExpressionException {
    assertEquals(reversePolish.evaluate("4 5 7 9 2 5 2 + - * / * -"), (float) 4.77);
  }

  // Test 14
  @Test
  void test11() throws InvalidExpressionException {
    assertEquals(reversePolish.evaluate("1 3 2 * -"), (float) -5);
  }
  
  // Test 15
  @Test
  void test12() throws InvalidExpressionException {
    assertThrows(InvalidExpressionException.class, () -> reversePolish.evaluate("1 a ^"));
  }
}