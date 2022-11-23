package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStandardCalc {
  StandardCalc stdExpr;

  @BeforeEach
  void setup() {
    stdExpr = new StandardCalc();
  }

  // Test 1
  // Test constructor
  @Test
  void test() {
    stdExpr = new StandardCalc();
  }

  // Test 2
  // Test a basic expression
  @Test
  void testSimpleExpression() throws InvalidExpressionException {
    assertEquals(stdExpr.evaluate("1 + 1"), 2);
  }

  // Test 3
  // Test if the conversion is successful
  @Test
  void testSymbol() {
    assertEquals(stdExpr.stringToSymbol("*"), Symbol.TIMES);
  }

  // Test 4
  // Test the conversion with an invalid symbol
  @Test
  void testSymbolInvalid() {
    assertEquals(stdExpr.stringToSymbol("^"), Symbol.INVALID);
  }

  // Test 5
  // Set of tests with different expressions, only 2 operands
  @Test
  void testSimpleExpression2() throws InvalidExpressionException {
    assertEquals(stdExpr.evaluate("13 - 1"), 12);
  }

  // Test 6
  @Test
  void testSimpleExpression3() throws InvalidExpressionException {
    assertEquals(stdExpr.evaluate("7 / 4"), (float) 1.75);
  }

  // Test 7
  @Test
  void testSimpleExpression4() throws InvalidExpressionException {
    assertEquals(stdExpr.evaluate("9 * 7"), 63);
  }

  // Test 8
  // Set of tests with multiple operands and operators
  @Test
  void testExpression1() throws InvalidExpressionException {
    assertEquals(stdExpr.evaluate("1 + 3 - 6"), -2);
  }

  // Test 9
  @Test
  void testExpression2() throws InvalidExpressionException {
    assertEquals(stdExpr.evaluate("7 / 2 * 6"), (float) 0.58);
  }

  // Test 10
  @Test
  void testExpression3() throws InvalidExpressionException {
    assertEquals(stdExpr.evaluate("89 - 5 / 3"), (float) 87.33);
  }

  // Test 11
  @Test
  void testExpression4() throws InvalidExpressionException {
    assertEquals(stdExpr.evaluate("8 - 5 / 3 * 5 + 9"), (float) 7.88);
  }
}
