package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCheckElement {
  CheckElement check;

  @BeforeEach
  void setup() {
    check = new CheckElement();
  }

  // Test 1
  // Test a valid symbol
  @Test
  void testCheckSymbol() {
    assertTrue(check.checkSymbol("+"),
        "+ is a valid symbol. Can be used to evaluate the expression");
  }

  // Test 2
  // Test an invalid symbol
  @Test
  void testCheckSymbolInvalid() {
    assertFalse(check.checkSymbol("&"), "& is not a valid symbol to calculate the expression");
  }

  // Test 3
  // Test if a string contains only digits
  @Test
  void testIsDigit() {
    assertTrue(check.isDigit("10"));
  }

  // Test 4
  // Test if the method returns false when the string contains other characters
  @Test
  void testIsNotDigit() {
    assertFalse(check.isDigit("1$8"));
  }
}
