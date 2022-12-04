package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStandardCalc {

  StandardCalc stdCalc;

  @BeforeEach
  void setup() {
    stdCalc = new StandardCalc();
  }

  // Test 1
  // Test constructor
  @Test
  void test() {
    stdCalc = new StandardCalc();
  }

  // Test 2
  // Test a simple expression
  @Test
  void test2() throws InvalidExpressionException {
    assertEquals(stdCalc.evaluate("1 + 1"), 2, "The mathematical expression '1 + 1' evaluate to 2");
  }

  // Test 3
  @Test
  void test3() throws InvalidExpressionException {
    assertEquals(stdCalc.evaluate("1 + 3 - 6"), -2);
  }

  // ---------------------------------------------------------------------------
  // Test 4
  // Test if a string character is successfully converted to a symbol
  // Set of full sets to test all possible inputs for method strToSymbol()
  @Test
  void testStrToSymbol1() {
    assertEquals(stdCalc.strToSymbol("*"), Symbol.TIMES);
  }

  // Test 5
  @Test
  void testStrToSymbol2() {
    assertEquals(stdCalc.strToSymbol("/"), Symbol.DIVIDE);
  }

  // Test 6
  @Test
  void testStrToSymbol3() {
    assertEquals(stdCalc.strToSymbol("-"), Symbol.MINUS);
  }

  // Test 7
  @Test
  void testStrToSymbol4() {
    assertEquals(stdCalc.strToSymbol("+"), Symbol.PLUS);
  }

  // Test 8
  @Test
  void testStrToSymbol5() {
    assertEquals(stdCalc.strToSymbol("^"), Symbol.INVALID);
  }

  // Test 8
  @Test
  void testStrToSymbol6() {
    assertEquals(stdCalc.strToSymbol("*-"), Symbol.INVALID);
  }

  // Test 9
  @Test
  void testStrToSymbol7() {
    assertEquals(stdCalc.strToSymbol(")"), Symbol.LEFT_BRACKET);
  }
  // ---------------------------------------------------------------------------

  // Test 10
  // Expression with all possible operands
  @Test
  void testExprAllOperands() throws InvalidExpressionException {
    assertEquals(stdCalc.evaluate("1 + 2 - 8 * 3 / 9"), (float) 0.33);
  }

  // Test 11
  // Expression with parenthesis
  @Test
  void testExprParanthesis() throws InvalidExpressionException {
    assertEquals(stdCalc.evaluate("( 1 + 2 ) * 4"), (float) 12);
  }

  // Test 12
  @Test
  void testExprParanthesis2() throws InvalidExpressionException {
    assertEquals(stdCalc.evaluate("4 * ( 1 + 2 )"), (float) 12);
  }

  // Test 13
  @Test
  void testExprParanthesis3() throws InvalidExpressionException {
    assertEquals(stdCalc.evaluate("4 * ( 1 + 2 ) + 9 - ( 3 + 2 )"), (float) 28);
  }

  // Test 14
  // Test if an exception is thrown if a mathematical expression in Reverse Polish Notation is being
  // calculated using the infix state of the calculator
  @Test
  void testInvalidExpression() throws InvalidExpressionException {
    assertThrows(InvalidExpressionException.class, () -> stdCalc.evaluate("1 5 -"));
  }

  // Test 15
  // Test if an exception is thrown if a mathematical expression contains invalid operands
  @Test
  void testInvalidExpression2() throws InvalidExpressionException {
    assertThrows(InvalidExpressionException.class, () -> stdCalc.evaluate("1 ^ 7"));
  }

  // Test 16
  // Test if an exception is thrown if a mathematical expression contains invalid operators
  @Test
  void testInvalidExpression3() throws InvalidExpressionException {
    assertThrows(InvalidExpressionException.class, () -> stdCalc.evaluate("1 - e"));
  }

  // Test 17
  // Test if an exception is thrown if a mathematical expression in Reverse Polish Notation is being
  // calculated using the infix state of the calculators
  @Test
  void test13() throws InvalidExpressionException {
    assertThrows(InvalidExpressionException.class, () -> stdCalc.evaluate("1 + 2 + 3 4 +"));
  }

  // Test 18
  @Test
  void test14() throws InvalidExpressionException {
    assertThrows(InvalidExpressionException.class, () -> stdCalc.evaluate("( 1 + 2 ) 4 6 -"));
  }
}