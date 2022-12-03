package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCalcModel {

  CalcModel model;

  @BeforeEach
  void setup() {
    model = new CalcModel();
  }

  // Test 1
  @Test
  void test() {
    model = new CalcModel();
  }

  // Test 2
  // Test an infix expression
  @Test
  void testInfixExpression() throws InvalidExpressionException {
    model.setType(true);
    assertEquals(model.evaluate("1 + 2"), (float) 3);
  }

  // Test 3
  // Test a reverse polish notation expression
  @Test
  void testRevPolishExpression() throws InvalidExpressionException {
    model.setType(false);
    assertEquals(model.evaluate("1 5 -"), (float) -4);
  }

  // Test 4
  // Test an more complex infix expression
  @Test
  void testInfixExpression2() throws InvalidExpressionException {
    model.setType(true);
    assertEquals(model.evaluate("1 + 2 * 7 - 3"), (float) 9);
  }

  // Test 5
  // Test an invalid infix expression
  @Test
  void testInfixExpressionInvalid() throws InvalidExpressionException {
    model.setType(true);
    assertThrows(InvalidExpressionException.class, () -> model.evaluate("1 + 2 * 7 ^ 3"));
  }
  
  // Test 6
  // Test a more complex infix expression
  @Test
  void testRevPolishExpression2() throws InvalidExpressionException {
    model.setType(false);
    assertEquals(model.evaluate("1 2 + 7 3 * -"), (float) -18);
  }
  
  // Test 7
  // Test a more complex infix expression
  @Test
  void testREvPolishExpression3() throws InvalidExpressionException {
    model.setType(false);
    assertEquals(model.evaluate("6 2 9 7 + - *"), (float) -84);
  }
  
  // Test 8
  // Test an invalid reverse polish notation expression
  @Test
  void testRevPolishExpressionInvalid() throws InvalidExpressionException {
    model.setType(false);
    assertThrows(InvalidExpressionException.class, () -> model.evaluate("3 7 8 + ^"));
  }
}
