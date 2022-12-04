package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class TestEntry {

  Entry floatEntry;
  Entry stringEntry;
  Entry symbolEntry;

  // Test 1
  // test if the constructors can be used to create new entries
  @Test
  void testConstructor() {
    floatEntry = new Entry((float) 1.5);

    stringEntry = new Entry("Hello World!");

    symbolEntry = new Entry(Symbol.MINUS);
  }

  // Test 2
  @Test
  void testStringGetter() throws BadTypeException {
    stringEntry = new Entry("Hello world");
    assertTrue(stringEntry.getStr().equals("Hello world"));
  }

  // Test 3
  @Test
  void testFloatGetter() throws BadTypeException {
    floatEntry = new Entry(7.35f);
    assertEquals(floatEntry.getValue(), (float)7.35,
        "The get method should return the same value as set in the constructor.");
  }

  // Test 4
  @Test
  void testSymbolGetter() throws BadTypeException {
    symbolEntry = new Entry(Symbol.PLUS);
    assertTrue(symbolEntry.getOther().toString().equals("+ is addition sign"));
  }

  // Test 5
  @Test
  void testStringException() throws BadTypeException {
    stringEntry = new Entry("hello");
    assertThrows(BadTypeException.class, () -> stringEntry.getOther(), "The entry is not of type Symbol");
  }

  // Test 6 test float type error
  @Test
  void testFloatException() {
    floatEntry = new Entry(1.689f);
    assertThrows(BadTypeException.class, () -> floatEntry.getStr(),
        "The entry is of type float, not allowed to call string getter on the entry");
  }

  // Test 7
  @Test
  void testSymbolException() {
    symbolEntry = new Entry(Symbol.LEFT_BRACKET);
    assertThrows(BadTypeException.class, () -> symbolEntry.getStr(),
        "The entry is of type Symbol, not allowed to call string getter on the entry.");
  }

  // Test 8
  @Test
  void testToStringEntry() {
    symbolEntry = new Entry(Symbol.MINUS);
    assertTrue(symbolEntry.toString().equals("The entry is of type: Symbol data type"));
  }
}
