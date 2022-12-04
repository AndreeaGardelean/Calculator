package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStrStack {
  StrStack stringStack;

  // Instantiate the object before each test run
  @BeforeEach
  void setup() {
    stringStack = new StrStack();
  }

  // Test 1
  // Test if object can be instantiated
  @Test
  void test() {
    stringStack = new StrStack();
  }

  // Test 2
  // Test if the Stack is empty
  @Test
  void testIsEmpty() {
    assertTrue(stringStack.isEmpty(), "The stack is empty.");
  }

  // Test 3
  // Push item onto the Stack and check if it is still empty
  @Test
  void testPush() {
    stringStack.push("1st string pushed.");
    assertFalse(stringStack.isEmpty(), "The stack is not empty, a string has been pushed.");
  }

  // Test 4
  // Push multiple items onto the Stack and check if pop() return the last item pushed
  @Test
  void testPop() throws EmptyStackException, BadTypeException {
    stringStack.push("String 1");
    stringStack.push("String 2");
    stringStack.push("String 3");
    assertTrue(stringStack.pop().equals("String 3"),
        "The last item pushed is the first item popped.");
  }

  // Test 5
  // Check if an exception is thrown when a pop is done on an empty Stack
  @Test
  void testEmptyStackPop() {
    assertThrows(EmptyStackException.class, () -> stringStack.pop(),
        "The stack is empty, pop not allowed.");
  }
}
