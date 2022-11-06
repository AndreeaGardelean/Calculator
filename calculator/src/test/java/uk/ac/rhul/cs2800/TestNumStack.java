package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestNumStack {

  NumStack stackNums;

  // create an object before each test
  @BeforeEach
  void setup() {
    stackNums = new NumStack();
  }

  // Test 1
  // Test if the NumStack object can be instantiated
  @Test
  void test() {
    stackNums = new NumStack();
  }

  // Test 2
  // Test if the stack is empty
  @Test
  void testIsEmpty() throws EmptyStackException {
    assertTrue(stackNums.isEmpty(), "No elements in the stack have been added.");
  }

  // Test 3
  // Push and check if the stack is still empty
  @Test
  void testPush() {
    stackNums.push(0.77f);
    assertFalse(stackNums.isEmpty(), "One pushed item should give a non empty stack");
  }

  // Test 4
  // Push multiple float entries to the stack and check if its still empty
  @Test
  void testPushMore() {
    for (int i = 0; i < 5; i++) {
      stackNums.push(i * 1.5f);
    }
    assertFalse(stackNums.isEmpty(), "Pushing multiple items should give a non empty stack");
  }

  // Test 5
  @Test
  void testPop() throws BadTypeException {
    stackNums.push(0.33f);
    stackNums.push(2.890f);

    assertEquals(stackNums.pop(), 2.890f,
        "Pushing twice and poping once should return the last item pushed: 2.890");
    assertEquals(stackNums.pop(), 0.33f,
        "Pushing twice and poping twice should return the last item pushed: 0.33");
    assertTrue(stackNums.isEmpty(), "Pushing and popping twice should give an empty stack");
  }

  // Test 6
  // Test if popping an empty stack returns an exception
  @Test
  void testEmptyStackPop() {
    assertThrows(EmptyStackException.class, () -> stackNums.pop(),
        "The stack is empty, pop not allowed.");
  }
}


