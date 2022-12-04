package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestOpStack {

  OpStack symbolStack;

  // Instantiate the object before each test run
  // This will create a clean object for each test
  @BeforeEach
  void setup() {
    symbolStack = new OpStack();
  }

  // Test 1
  // Test if the object can be instantiated
  @Test
  void test() {
    symbolStack = new OpStack();
  }

  // Test 2
  // Test if a symbol can be pushed onto the stack
  @Test
  void testPush() {
    symbolStack.push(Symbol.PLUS);
  }
  
  //Test 3
  // Test if the method returns true for an empty stack
  @Test
  void testIsEmpty() throws EmptyStackException {
    assertTrue(symbolStack.isEmpty());
  }
  
  // Test 4
  // Test if the pop method returns the last item from the stack and its size is updated
  @Test
  void testPop() throws BadTypeException, EmptyStackException {
    symbolStack.push(Symbol.DIVIDE);
    symbolStack.push(Symbol.LEFT_BRACKET);

    assertTrue(symbolStack.pop().equals(Symbol.LEFT_BRACKET),
        "Popping the stack should return the last entry pushed");
    assertFalse(symbolStack.isEmpty(),
        "Pushing twice and popping once should give an non empty stack.");
  }
  
  // Test 5
  // Test if popping an empty stack returns an exception
  @Test
  void testEmptyStackPop() {
    assertThrows(EmptyStackException.class, () -> symbolStack.pop(),
        "The stack is empty, pop not allowed.");
  }
}