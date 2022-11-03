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
    NumStack numbers = new NumStack();
  }

  // Test 2
  @Test
  void testSize() {
    assertEquals(stackNums.size(), 0, "No elements in the stack have been added.");
  }
  
  // Test 3
  @Test
  void testPush() {
    stackNums.push(0.77f);
    assertEquals(stackNums.size(), 1, "One pushed item should give stack size 1.");
  }
  
  // Test 4
  // Push multiple float entryes to the stack and check its size
  @Test
  void testPushMore() {
    for (int i = 0; i < 5; i++) {
      stackNums.push(i*1.5f);
    }
    assertEquals(stackNums.size(), 5, "Pushing 5 items into the stack should return stack size 5.");
  }
  
  // Test 5
  @Test
  void testPop() throws BadTypeException {
    stackNums.push(0.33f);
    stackNums.push(2.890f);
    assertEquals(stackNums.size(), 2, "Pushing twice should return stack size 2.");
    
    assertEquals(stackNums.pop(), 2.890f, "Pushing twice and poping once should return the last item pushed: 2.890");
    assertEquals(stackNums.size(), 1, "Pushing twice and poping once should return stack size 1.");
  }
  
  // Test 5
  // Test if popping an empty stack return an exception
  // The EmptyStackException is thrown by the Stack class
  @Test
  void testEmptyStackPop() {
    assertThrows(EmptyStackException.class, () -> stackNums.pop(), "The stack is empty, pop not allowed.");
  }
  
  // Test 6
  // evaluate the feedback from the isEmpty() method
  @Test
  void testIsEmpty() {
    assertTrue(stackNums.isEmpty(), "The stack is empty.");
  }
  
  // Test 7
  // Test if a stack with one entry is empty
  @Test
  void testIsEmptyNonEmpty() {
    stackNums.push(0.0725f);
    assertFalse(stackNums.isEmpty(), "The stack is not empty.");
  }
}












